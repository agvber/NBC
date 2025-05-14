package com.nbc.search_image.domain.usecase

import com.nbc.search_image.common.coroutine.AppDispatchers
import com.nbc.search_image.common.coroutine.Dispatcher
import com.nbc.search_image.domain.model.Search
import com.nbc.search_image.domain.repository.BookmarkRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddBookmarkUseCase @Inject constructor(
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val bookmarkRepository: BookmarkRepository,
) {

    suspend operator fun invoke(search: Search) = withContext(ioDispatcher) {
        bookmarkRepository.addBookmark(search)
    }
}