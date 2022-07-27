package kz.flyingv.serverlessmessenger.data.storage.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kz.flyingv.serverlessmessenger.data.model.Chat
import kz.flyingv.serverlessmessenger.data.model.ChatInfo

@Dao
interface ChatDao {

    @Query("SELECT * FROM Chat")
    fun getAllFlow(): Flow<List<Chat>>

    @Query("SELECT * FROM Chat WHERE chatId = :chatId")
    fun getChat(chatId: Int): Chat?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(chat: Chat)

    @Delete
    fun delete(chat: Chat)

    /************************************/

    @Transaction
    @Query("SELECT * FROM Chat")
    fun getAllChatInfo(): Flow<List<ChatInfo>>

}