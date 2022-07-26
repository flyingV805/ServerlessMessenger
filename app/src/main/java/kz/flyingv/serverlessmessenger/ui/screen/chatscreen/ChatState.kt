package kz.flyingv.serverlessmessenger.ui.screen.chatscreen

import kz.flyingv.serverlessmessenger.data.model.Companion
import kz.flyingv.serverlessmessenger.data.model.Message

data class ChatState(
    val companion: Companion,
    val messages: List<Message>
)