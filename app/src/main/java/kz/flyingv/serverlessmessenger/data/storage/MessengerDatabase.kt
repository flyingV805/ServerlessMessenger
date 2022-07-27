package kz.flyingv.serverlessmessenger.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.flyingv.serverlessmessenger.data.model.Chat
import kz.flyingv.serverlessmessenger.data.model.Companion
import kz.flyingv.serverlessmessenger.data.model.Message
import kz.flyingv.serverlessmessenger.data.storage.dao.ChatDao
import kz.flyingv.serverlessmessenger.data.storage.dao.CompanionDao
import kz.flyingv.serverlessmessenger.data.storage.dao.MessageDao

@Database(entities = [Companion::class, Chat::class, Message::class], version = 1)
abstract class MessengerDatabase: RoomDatabase() {
    abstract fun companionDao(): CompanionDao
    abstract fun chatDao(): ChatDao
    abstract fun messageDao(): MessageDao
}