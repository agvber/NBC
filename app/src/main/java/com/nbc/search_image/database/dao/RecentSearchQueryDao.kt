package com.nbc.search_image.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.nbc.search_image.database.model.RecentSearchQueryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecentSearchQueryDao {

    @Query(
        value = """
        SELECT * FROM recent_search_query 
            ORDER BY queried_date 
                DESC LIMIT :limit
        """
    )
    fun getRecentSearchQueries(limit: Int = -1): Flow<List<RecentSearchQueryEntity>>

    @Upsert
    suspend fun upsertItem(recentSearchQueryEntity: RecentSearchQueryEntity)

    @Query(
        value = """
            DELETE FROM recent_search_query
        """
    )
    suspend fun deleteAll()

}