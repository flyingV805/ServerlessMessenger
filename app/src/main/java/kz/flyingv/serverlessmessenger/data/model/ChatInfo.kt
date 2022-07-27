package kz.flyingv.serverlessmessenger.data.model

import androidx.room.Embedded
import androidx.room.Relation

class ChatInfo {

    @Embedded
    lateinit var chat: Chat

    @Relation(parentColumn = "companionId", entityColumn = "id")
    lateinit var companion: List<Companion?>

    @Relation(parentColumn = "lastMessageId", entityColumn = "id")
    lateinit var latestMessage: List<Message?>

}