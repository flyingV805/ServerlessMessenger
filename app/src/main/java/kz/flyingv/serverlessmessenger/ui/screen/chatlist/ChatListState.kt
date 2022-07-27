package kz.flyingv.serverlessmessenger.ui.screen.chatlist

import kz.flyingv.serverlessmessenger.data.model.Chat
import kz.flyingv.serverlessmessenger.data.model.ChatInfo

data class ChatListState(
    val chats: List<ChatInfo>
)