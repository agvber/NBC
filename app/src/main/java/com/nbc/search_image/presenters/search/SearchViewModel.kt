package com.nbc.search_image.presenters.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nbc.search_image.domain.model.Search
import com.nbc.search_image.domain.usecase.AddBookmarkUseCase
import com.nbc.search_image.domain.usecase.DeleteBookmarkUseCase
import com.nbc.search_image.domain.usecase.GetRecentSearchQueries
import com.nbc.search_image.domain.usecase.GetSearchItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    getSearchItemsUseCase: GetSearchItemsUseCase,
    getRecentSearchQueries: GetRecentSearchQueries,
    private val addBookmarkUseCase: AddBookmarkUseCase,
    private val deleteBookmarkUseCase: DeleteBookmarkUseCase,
) : ViewModel() {

    val recentSearchQueries = getRecentSearchQueries()

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    fun updateQuery(query: String) {
        viewModelScope.launch {
            _query.emit(query)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val search: Flow<PagingData<Search>> =
        query.debounce(800L).flatMapLatest {
            if (it.isBlank()) {
                return@flatMapLatest emptyFlow()
            }

            getSearchItemsUseCase(it)
                .cachedIn(viewModelScope)
        }

    fun bookmarkItem(search: Search) {
        try {
            viewModelScope.launch {
                if (search.isFavorite) {
                    deleteBookmarkUseCase(search.id)
                    return@launch
                }
                addBookmarkUseCase(search)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}