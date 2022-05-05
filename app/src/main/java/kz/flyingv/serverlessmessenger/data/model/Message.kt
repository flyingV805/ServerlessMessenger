package kz.flyingv.serverlessmessenger.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val chatId: Long,
    val text: String,
    val name: String,
    val photoUrl: String,
    val imageUrl: String,
    val sentDatetime: Long
)
