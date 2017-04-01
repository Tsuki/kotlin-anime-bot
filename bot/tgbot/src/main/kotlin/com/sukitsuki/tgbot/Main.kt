package com.sukitsuki.tgbot

import okhttp3.logging.HttpLoggingInterceptor
import org.yanex.telegram.TelegramBot
import org.yanex.telegram.entities.Message
import org.yanex.telegram.entities.Update
import org.yanex.telegram.handler.AbstractUpdateVisitor
import org.yanex.telegram.handler.StopProcessingException
import org.yanex.telegram.handler.VisitorUpdateHandler

fun main(args: Array<String>) {
    val properties = TelegramProperties()
    val bot = TelegramBot.create(token = properties.token, logLevel = HttpLoggingInterceptor.Level.BASIC)

    val lastId = bot.listen(properties.lastId, VisitorUpdateHandler(object : AbstractUpdateVisitor() {
        override fun visitText(update: Update, message: Message, text: String) = when (text) {
            "ping" -> {
                sendText(update, "pong"); true
            }
//            "exit" -> throw StopProcessingException()
            else -> false
        }

        override fun visitUpdate(update: Update) = sendText(update, "Unknown command. Try 'ping'.")

        private fun sendText(update: Update, text: String) {
            bot.sendMessage(update.senderId, text)
        }
    }))
    properties.lastId = lastId
}
