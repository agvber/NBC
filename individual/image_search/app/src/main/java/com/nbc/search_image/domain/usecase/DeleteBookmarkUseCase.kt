package com.nbc.search_image.domain.usecase

import com.nbc.search_image.common.coroutine.AppDispatchers
import com.nbc.search_image.common.coroutine.Dispatcher
import com.nbc.search_image.domain.repository.BookmarkRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteBookmarkUseCase @Inject constructor(
    @Dispatcher(AppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val bookmarkRepository: BookmarkRepository,
) {

    suspend operator fun invoke(id: String) = withContext(ioDispatcher) {
        bookmarkRepository.deleteBookmark(id)
    }
}