package com.nbc.search_image.domain.repository

import com.nbc.search_image.domain.model.Bookmark
import com.nbc.search_image.domain.model.Search
import kotlinx.coroutines.flow.Flow

interface BookmarkRepository {

    suspend fun addBookmark(search: Search)

    suspend fun deleteBookmark(id: String)

    fun getBookmarkItems(): Flow<List<Bookmark>>
}