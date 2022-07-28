package kz.flyingv.serverlessmessenger.domain.repository

import kotlinx.coroutines.flow.Flow
import kz.flyingv.serverlessmessenger.data.model.Chat
import kz.flyingv.serverlessmessenger.data.model.ChatInfo
import kz.flyingv.serverlessmessenger.data.model.Companion
import kz.flyingv.serverlessmessenger.domain.repository.base.BaseRepository

interface ChatsRepository {

    fun getAllActive(): Flow<List<Chat>>
    fun getAllActiveWithInfo(): Flow<List<ChatInfo>>
    fun startChat(companion: Companion)

}

class ChatsRepositoryImpl: BaseRepository(), ChatsRepository {

    override fun getAllActive(): Flow<List<Chat>> = database.chatDao().getAllFlow()

    override fun getAllActiveWithInfo(): Flow<List<ChatInfo>> = database.chatDao().getAllChatInfo()

    override fun startChat(companion: Companion) {
        database.chatDao().insert(
            Chat(companionId = companion.id, lastMessageId = -1)
        )
    }
}