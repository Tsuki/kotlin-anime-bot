package com.sukitsuki.tgbot

import com.google.gson.Gson
import com.sukitsuki.telegram.TelegramHoopingBot
import com.sukitsuki.telegram.TelegramPollingBot
import com.sukitsuki.telegram.TelegramProperties
import com.sukitsuki.telegram.entities.Message
import com.sukitsuki.telegram.entities.Update
import com.sukitsuki.telegram.handler.AbstractUpdateVisitor
import com.sukitsuki.telegram.handler.StopProcessingException
import com.sukitsuki.telegram.handler.VisitorUpdateHandler
import com.sukitsuki.tgbot.service.BangumiService
import com.sukitsuki.tgbot.service.requestJson
import mu.KotlinLogging
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.joda.time.DateTime
import org.joda.time.Period
import org.joda.time.format.PeriodFormat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    val startTime = DateTime()
    val properties = TelegramProperties()
    logger.info { properties }
    val bot = when {
        properties.webHook -> TelegramHoopingBot.create(properties = properties, logLevel = Level.BASIC)
        else -> TelegramPollingBot.create(properties = properties)
    }

    val adapter = Retrofit.Builder()
            .baseUrl("https://bangumi.moe/api/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(bot.client)
            .build()
    val bangumiService = adapter.create(BangumiService::class.java)
    bot.listen(properties.lastId, VisitorUpdateHandler(visitor = object : AbstractUpdateVisitor() {
        override fun visitText(update: Update, message: Message, text: String): Boolean {
            when (text) {
                "/info", "/info@NatsukiBot" -> replayText(update, "Language: Kotlin \n" +
                        "Library: yat-kotlin-telegram-bot-api \n" +
                        "Running Time: ${PeriodFormat.getDefault().print(Period(startTime, DateTime().toInstant()))}")

                "/ping" -> sendText(update, "pong")

                "/anime", "/anime@NatsukiBot" -> {
                    val recent = bangumiService.recent().execute().body()
                    val tagMap = hashMapOf("_ids" to recent.filter { it.showOn == DateTime().dayOfWeek }.map { it.tagId })
                    val resultList = bangumiService.tag(requestJson(bot.gson.toJson(tagMap))).execute().body()
                    logger.info(resultList.toString())
                    replayText(update, resultList.joinToString("\n"))
                }

                "/exit" -> {
                    if (update.senderId in properties.admin) {
                        sendText(update, "Bot is closing.....")
                        throw StopProcessingException()
                    }
                    sendText(update, "關你撚事....")
                }
                else -> return false
            }
            return true
        }

        override fun visitUpdate(update: Update) {
            when {
                properties.handleUnknown -> sendText(update, "Unknown command. Try 'ping'.")
            }
        }

        private fun sendText(update: Update, text: String) {
            bot.sendMessage(update.senderId, text).execute()
        }

        private fun replayText(update: Update, text: String) {
            bot.sendMessage(update.senderId, text, replyToMessageId = update.message?.messageId).execute()
        }
    }))
}
