package kz.flyingv.serverlessmessenger.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Chat(
    @PrimaryKey(autoGenerate = true) val chatId: Long = 0,
    val companion: Companion
)