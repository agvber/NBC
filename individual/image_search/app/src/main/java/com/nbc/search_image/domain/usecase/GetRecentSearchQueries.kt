package com.nbc.search_image.domain.usecase

import com.nbc.search_image.domain.model.RecentSearchQuery
import com.nbc.search_image.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentSearchQueries @Inject constructor(
    private val searchRepository: SearchRepository
) {

    operator fun invoke(limit: Int = 1): Flow<List<RecentSearchQuery>> =
        searchRepository.getRecentQueries(limit)
}