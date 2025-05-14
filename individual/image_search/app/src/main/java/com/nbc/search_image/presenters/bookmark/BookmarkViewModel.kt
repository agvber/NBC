package com.nbc.search_image.presenters.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbc.search_image.domain.model.Bookmark
import com.nbc.search_image.domain.repository.BookmarkRepository
import com.nbc.search_image.domain.usecase.DeleteBookmarkUseCase
import com.nbc.search_image.domain.usecase.GetBookmarkItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    getBookmarkItemsUseCase: GetBookmarkItemsUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {

    val bookmarks: Flow<List<Bookmark>> = getBookmarkItemsUseCase()

    fun deleteBookmark(bookmark: Bookmark) {
        try {
            viewModelScope.launch {
                deleteBookmarkUseCase(bookmark.id)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}