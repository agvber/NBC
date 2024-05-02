package com.nbc.search_image.domain.usecase

import com.nbc.search_image.domain.model.Bookmark
import com.nbc.search_image.domain.repository.BookmarkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookmarkItemsUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) {

    operator fun invoke(): Flow<List<Bookmark>> =
        bookmarkRepository.getBookmarkItems()

}