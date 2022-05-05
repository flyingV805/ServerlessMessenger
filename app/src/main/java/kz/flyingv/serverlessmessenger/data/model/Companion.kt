package kz.flyingv.serverlessmessenger.data.model

import androidx.room.Entity

@Entity
data class Companion(
    val photoUrl: String,
    val displayName: String,
    val nickname: String,
    val firebaseToken: String
)