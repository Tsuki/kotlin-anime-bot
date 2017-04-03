package com.sukitsuki.tgbot

import com.sukitsuki.telegram.TelegramHoopingBot
import com.sukitsuki.telegram.TelegramPollingBot
import com.sukitsuki.telegram.TelegramProperties
import com.sukitsuki.telegram.entities.Message
import com.sukitsuki.telegram.entities.Update
import com.sukitsuki.telegram.handler.AbstractUpdateVisitor
import com.sukitsuki.telegram.handler.VisitorUpdateHandler
import com.sukitsuki.tgbot.entities.Recent
import io.vertx.core.AsyncResult
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.client.HttpResponse
import io.vertx.ext.web.client.WebClient
import mu.KotlinLogging
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import org.joda.time.Period
import org.joda.time.format.PeriodFormat
import org.ocpsoft.prettytime.PrettyTime


private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    val startTime = DateTime()
    val prettyTime = PrettyTime()
    val properties = TelegramProperties()
    logger.info { properties }
    val bot = when {
        properties.webHook -> TelegramHoopingBot.create(properties = properties, logLevel = HttpLoggingInterceptor.Level.BODY)
        else -> TelegramPollingBot.create(properties = properties)
    }
    val webClient = WebClient.create(bot.vertx)

    bot.listen(properties.lastId, VisitorUpdateHandler(visitor = object : AbstractUpdateVisitor() {
        override fun visitText(update: Update, message: Message, text: String): Boolean {
            when (text) {
                "/info", "/info@NatsukiBot" -> replayText(update, "Language: Kotlin \n" +
                        "Library: yat-kotlin-telegram-bot-api \n" +
                        "Running Time: ${PeriodFormat.getDefault().print(Period(startTime, DateTime().toInstant()))}")
                "/ping" -> sendText(update, "pong")
                "/anime", "/anime@NatsukiBot" -> {
                    val function: (AsyncResult<HttpResponse<Buffer>>) -> Unit = {
                        val response = it.result()
                        val json = bot.gson.fromJson(response.bodyAsString(), arrayOf(Recent()).javaClass)
                        sendText(update, json.filter { it.showOn == DateTime().dayOfWeek }.toList().joinToString("\n"))
                    }
                    webClient.getAbs("https://bangumi.moe/api/bangumi/recent").send(function)
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
            logger.debug("${call.request().body()}")
            logger.debug("${call.execute().body()}")
        }

        private fun replayText(update: Update, text: String) {
            val call = bot.sendMessage(chatId = update.senderId, text = text, replyToMessageId = update.message?.messageId)
            logger.debug("${call.request().body()}")
            logger.debug("${call.execute().body()}")
        }
    }))

}
