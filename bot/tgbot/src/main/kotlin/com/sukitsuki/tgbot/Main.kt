package com.sukitsuki.tgbot

import com.sukitsuki.telegram.TelegramHoopingBot
import com.sukitsuki.telegram.TelegramPollingBot
import com.sukitsuki.telegram.TelegramProperties
import com.sukitsuki.telegram.entities.Message
import com.sukitsuki.telegram.entities.Update
import com.sukitsuki.telegram.handler.AbstractUpdateVisitor
import com.sukitsuki.telegram.handler.StopProcessingException
import com.sukitsuki.telegram.handler.VisitorUpdateHandler
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {

    val properties = TelegramProperties()
    logger.info { properties }
    val bot = when {
        properties.webHook -> TelegramHoopingBot.create(properties = properties)
        else -> TelegramPollingBot.create(properties = properties)
    }
    bot.listen(properties.lastId, VisitorUpdateHandler(object : AbstractUpdateVisitor() {
        override fun visitText(update: Update, message: Message, text: String) = when (text) {
            "/ping"  -> {
                sendText(update, "pong")
            }
            "exit" -> throw StopProcessingException()
            else -> false
        }

        override fun visitUpdate(update: Update): Unit {
            when {
                properties.handleUnknown -> sendText(update, "Unknown command. Try 'ping'.")
                else -> Unit
            }
            return Unit
        }

        private fun sendText(update: Update, text: String):Boolean {
            bot.sendMessage(update.senderId, text).execute()
            return true
        }
    }))
}
