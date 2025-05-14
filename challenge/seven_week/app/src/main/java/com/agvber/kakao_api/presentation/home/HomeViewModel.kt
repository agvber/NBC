package com.agvber.kakao_api.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agvber.kakao_api.domain.di.DomainModule
import com.agvber.kakao_api.domain.model.Image
import com.agvber.kakao_api.domain.model.Video
import com.agvber.kakao_api.domain.usecase.GetImageListUseCase
import com.agvber.kakao_api.domain.usecase.GetVideListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf

class HomeViewModel(
    getImageListUseCase: GetImageListUseCase,
    getVideListUseCase: GetVideListUseCase,
) : ViewModel() {

    private val _query: MutableStateFlow<String> = MutableStateFlow("카카오톡")
    val query: StateFlow<String> = _query.asStateFlow()

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val homeViewUiState: Flow<List<HomeViewUiState>> = query.flatMapLatest { query ->

        val imageList = getImageListUseCase(query).map {
            HomeViewUiState.ImageItem(it)
        }

        val videoList = getVideListUseCase(query).map {
            HomeViewUiState.VideoItem(it)
        }

        flowOf((imageList + videoList).shuffled())
    }
    companion object {
        val viewModelFactory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val getImageListUseCase = DomainModule.bindGetImageListUseCase()
                val getVideListUseCase = DomainModule.bindGetVideoListUseCase()
                return HomeViewModel(getImageListUseCase, getVideListUseCase) as T
            }
        }
    }
}

sealed interface HomeViewUiState {

    data class ImageItem(val data: Image) : HomeViewUiState

    data class VideoItem(val data: Video) : HomeViewUiState
}