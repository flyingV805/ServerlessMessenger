package kz.flyingv.serverlessmessenger.data.storage.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kz.flyingv.serverlessmessenger.data.model.Companion

@Dao
interface CompanionDao {

    @Query("SELECT * FROM Companion")
    fun getAllFlow(): Flow<List<Companion>>

    @Query("SELECT * FROM Companion WHERE id = :companionId")
    fun getCompanion(companionId: Int): Companion?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(companion: Companion): Long

    @Delete
    fun delete(companion: Companion)

}