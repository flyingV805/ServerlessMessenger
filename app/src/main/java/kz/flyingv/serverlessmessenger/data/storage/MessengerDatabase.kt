package kz.flyingv.serverlessmessenger.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.flyingv.serverlessmessenger.data.model.Message

@Database(entities = [Message::class], version = 1)
abstract class MessengerDatabase: RoomDatabase() {

}