package com.nbc.search_image.domain.usecase

import androidx.paging.PagingData
import com.nbc.search_image.domain.model.Search
import com.nbc.search_image.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchItemsUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
) {

    operator fun invoke(query: String): Flow<PagingData<Search>> =
        searchRepository.getSearchImage(query)
}