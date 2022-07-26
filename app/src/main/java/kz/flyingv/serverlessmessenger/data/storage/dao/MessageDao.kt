package kz.flyingv.serverlessmessenger.data.storage.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kz.flyingv.serverlessmessenger.data.model.Message

@Dao
interface MessageDao {

    @Query("SELECT * FROM Message WHERE chatId = :chatId")
    fun getAllForChatFlow(chatId: Int): Flow<List<Message>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(message: Message)

    @Delete
    fun delete(message: Message)

}