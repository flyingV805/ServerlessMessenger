package kz.flyingv.serverlessmessenger.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class AppUser(
    val userId: String? = null,
    val userNickname: String? = null,
    val userName: String? = null,
    val userPhotoUrl: String? = null
)