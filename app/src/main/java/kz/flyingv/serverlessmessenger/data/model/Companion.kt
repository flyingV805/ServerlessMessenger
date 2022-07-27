package kz.flyingv.serverlessmessenger.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Companion(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    val photoUrl: String,
    val displayName: String,
    val nickname: String,
    val firebaseToken: String
)