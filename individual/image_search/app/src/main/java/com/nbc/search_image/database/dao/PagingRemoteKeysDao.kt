package com.nbc.search_image.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.nbc.search_image.database.model.PagingRemoteKeysEntity

@Dao
interface PagingRemoteKeysDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<PagingRemoteKeysEntity>)

    @Transaction
    @Query("SELECT * FROM paging_remote_keys WHERE queried = :queried")
    suspend fun getRemoteKeys(queried: String): PagingRemoteKeysEntity?

    @Transaction
    @Query("DELETE FROM paging_remote_keys")
    suspend fun clearRemoteKeys()
}