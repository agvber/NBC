package com.nbc.search_image.data.di

import com.nbc.search_image.data.repository.BookmarkRepositoryImpl
import com.nbc.search_image.data.repository.SearchRepositoryImpl
import com.nbc.search_image.domain.repository.BookmarkRepository
import com.nbc.search_image.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsNewResourceRepository(
        newResourceRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    fun bindsBookmarkRepository(
        bookmarkRepositoryImpl: BookmarkRepositoryImpl
    ): BookmarkRepository
}