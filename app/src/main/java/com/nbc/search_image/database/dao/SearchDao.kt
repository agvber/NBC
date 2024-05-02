package com.nbc.search_image.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.nbc.search_image.database.model.SearchEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface SearchDao {

    @Query(
        value = """
        SELECT * FROM search LIMIT :limit
        """
    )
    fun getAll(limit: Int = -1): Flow<List<SearchEntity>>

    @Query(
        """
            SELECT * FROM search WHERE id = :id
        """
    )
    suspend fun getItem(id: String): List<SearchEntity>

    @Query(
        value = """
        SELECT search.id, search.date_time, 
        search.title, search.original_url, 
        search.thumbnail_url, bookmark.is_bookmark AS is_favorite
        FROM search
            LEFT OUTER JOIN bookmark
            ON search.id == bookmark.id
        """
    )
    fun getPagingSource(): PagingSource<Int, SearchEntity>

    @Insert
    suspend fun insertItem(searchEntity: SearchEntity)

    @Update
    suspend fun insertOrReplaceItem(searchEntity: SearchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReplaceAll(newResourceEntities: List<SearchEntity>)

    @Query(
        value = """
            DELETE FROM search WHERE id in (:ids)
        """,
    )
    suspend fun deleteItems(ids: List<String>)

    @Query("DELETE FROM search")
    suspend fun clear()
}