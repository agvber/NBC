package com.nbc.search_image.database.di

import com.nbc.search_image.database.dao.SearchDao
import com.nbc.search_image.database.dao.PagingRemoteKeysDao
import com.nbc.search_image.database.dao.BookmarkDao
import com.nbc.search_image.database.dao.RecentSearchQueryDao
import com.nbc.search_image.database.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun providesNewResourceDao(
        database: AppDatabase,
    ): SearchDao = database.newResourceDao()

    @Provides
    fun providesStorageBoxDao(
        database: AppDatabase,
    ): BookmarkDao = database.storageBoxDao()

    @Provides
    fun providesRemoteKeyDao(
        database: AppDatabase
    ): PagingRemoteKeysDao = database.pagingRemoteKeysDao()

    @Provides
    fun providesRecentQueryDao(
        database: AppDatabase
    ): RecentSearchQueryDao = database.recentSearchQueryDao()
}