package com.nbc.search_image.domain.repository

import androidx.paging.PagingData
import com.nbc.search_image.domain.model.RecentSearchQuery
import com.nbc.search_image.domain.model.Search
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    fun getSearchImage(query: String): Flow<PagingData<Search>>

    fun getRecentQueries(limit: Int = -1): Flow<List<RecentSearchQuery>>
}