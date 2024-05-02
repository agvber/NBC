package com.nbc.search_image.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nbc.search_image.database.dao.BookmarkDao
import com.nbc.search_image.database.dao.PagingRemoteKeysDao
import com.nbc.search_image.database.dao.RecentSearchQueryDao
import com.nbc.search_image.database.dao.SearchDao
import com.nbc.search_image.database.model.BookmarkEntity
import com.nbc.search_image.database.model.PagingRemoteKeysEntity
import com.nbc.search_image.database.model.RecentSearchQueryEntity
import com.nbc.search_image.database.model.SearchEntity

@Database(
    entities = [
        SearchEntity::class,
        BookmarkEntity::class,
        PagingRemoteKeysEntity::class,
        RecentSearchQueryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newResourceDao(): SearchDao
    abstract fun storageBoxDao(): BookmarkDao
    abstract fun pagingRemoteKeysDao(): PagingRemoteKeysDao
    abstract fun recentSearchQueryDao(): RecentSearchQueryDao
}