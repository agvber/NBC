package com.nbc.search_image.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nbc.search_image.database.model.BookmarkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {

    @Query(
        """
        SELECT * FROM bookmark LIMIT :limit
    """
    )
    fun getAll(limit: Int = -1): Flow<List<BookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(bookmarkEntity: BookmarkEntity)

    @Query(
        """
            DELETE FROM bookmark WHERE id in (:ids)
        """
    )
    suspend fun deleteItems(ids: List<String>)
}