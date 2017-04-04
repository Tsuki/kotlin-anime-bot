package com.sukitsuki.tgbot

import com.google.gson.Gson
import com.sukitsuki.telegram.TelegramHoopingBot
import com.sukitsuki.telegram.TelegramPollingBot
import com.sukitsuki.telegram.TelegramProperties
import com.sukitsuki.telegram.entities.Message
import com.sukitsuki.telegram.entities.Update
import com.sukitsuki.telegram.handler.AbstractUpdateVisitor
import com.sukitsuki.telegram.handler.VisitorUpdateHandler
import com.sukitsuki.tgbot.service.BangumiService
import io.vertx.ext.web.client.WebClient
import mu.KotlinLogging
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
        properties.webHook -> TelegramHoopingBot.create(properties = properties)
        else -> TelegramPollingBot.create(properties = properties)
    }
    val webClient = WebClient.create(bot.vertx)

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
                    val execute = bangumiService.recent().execute()
                    logger.info(execute.body().toString())
//                    val function: (AsyncResult<HttpResponse<Buffer>>) -> Unit = {
//                        val response = it.result()
//                        val json = bot.gson.fromJson(response.bodyAsString(), arrayOf(Recent()).javaClass)
//                        sendText(update, json.filter { it.showOn == DateTime().dayOfWeek }.toList().joinToString("\n"))
//                    }
//                    webClient.getAbs("https://bangumi.moe/api/bangumi/recent").send(function)
                }
//                "exit" -> throw StopProcessingException()
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
            val call = bot.sendMessage(update.senderId, text)
        }

        private fun replayText(update: Update, text: String) {
            val call = bot.sendMessage(chatId = update.senderId, text = text, replyToMessageId = update.message?.messageId)
        }
    }))

}
