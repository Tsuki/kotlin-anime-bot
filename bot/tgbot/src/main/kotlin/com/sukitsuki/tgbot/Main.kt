package com.sukitsuki.tgbot

import mu.KotlinLogging
import org.yanex.telegram.TelegramHoopingBot
import org.yanex.telegram.TelegramPollingBot
import org.yanex.telegram.TelegramProperties
import org.yanex.telegram.entities.Message
import org.yanex.telegram.entities.Update
import org.yanex.telegram.extention.toStrings
import org.yanex.telegram.handler.AbstractUpdateVisitor
import org.yanex.telegram.handler.StopProcessingException
import org.yanex.telegram.handler.VisitorUpdateHandler

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {

    val properties = TelegramProperties()
    logger.info { properties }
    val bot = when {
        properties.webHook -> TelegramHoopingBot.create(properties = properties)
        else -> TelegramPollingBot.create(properties = properties)
    }
    val lastId = bot.listen(properties.lastId, VisitorUpdateHandler(object : AbstractUpdateVisitor() {
        override fun visitText(update: Update, message: Message, text: String) = when (text) {
            "ping" -> {
                sendText(update, "pong"); true
            }
            "exit" -> throw StopProcessingException()
            else -> false
        }

        override fun visitUpdate(update: Update) = when {
            properties.handleUnknown -> sendText(update, "Unknown command. Try 'ping'.")
            else -> Unit
        }

        private fun sendText(update: Update, text: String) {
            bot.sendMessage(update.senderId, text).execute()
        }
    }))
    properties.lastId = lastId
}
