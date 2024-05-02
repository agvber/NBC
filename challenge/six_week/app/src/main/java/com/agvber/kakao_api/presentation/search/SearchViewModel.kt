package com.agvber.kakao_api.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.agvber.kakao_api.data.repository.ImageRepository
import com.agvber.kakao_api.data.repository.ImageRepositoryImpl
import com.agvber.kakao_api.domain.GetImageListUseCase
import com.agvber.kakao_api.model.Images
import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.retrofit.RetrofitNetwork
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val getImageListUseCase: GetImageListUseCase,
) : ViewModel() {

    private val _query: MutableStateFlow<String> = MutableStateFlow("코틀린")
    val query: StateFlow<String> = _query.asStateFlow()

    fun updateQuery(query: String) {
        viewModelScope.launch {
            _query.emit(query)
        }
    }

    private val _itemCheckedSet: MutableStateFlow<Set<String>> = MutableStateFlow(emptySet())
    val itemCheckedSet: StateFlow<Set<String>> = _itemCheckedSet.asStateFlow()

    fun updateItemCheckSet(checkedSet: (Set<String>) -> Set<String>) {
        _itemCheckedSet.update(checkedSet)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val images: Flow<PagingData<Images.Item>> = query.flatMapLatest {
        if (it.isBlank()) {
            return@flatMapLatest emptyFlow()
        }

        getImageListUseCase(query = it)
            .flow
            .cachedIn(viewModelScope)
    }

    companion object {
        val viewModelFactory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val networkDataSource: NetworkDataSource = RetrofitNetwork()
                val imageRepository: ImageRepository = ImageRepositoryImpl(networkDataSource)
                val getImageListUseCase = GetImageListUseCase(imageRepository)

                return SearchViewModel(
                    getImageListUseCase
                ) as T
            }
        }
    }
}