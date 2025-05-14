package com.agvber.kakao_api.domain.usecase

import androidx.paging.PagingData
import com.agvber.kakao_api.domain.model.Sort
import com.agvber.kakao_api.domain.model.Video
import com.agvber.kakao_api.domain.repository.VideoRepository
import kotlinx.coroutines.flow.Flow

class GetVideListUseCase(
    private val videoRepository: VideoRepository
) {

     suspend operator fun invoke(
        query: String,
        sort: Sort = Sort.ACCURACY,
    ): List<Video> {
        return videoRepository.getVide(query = query, sort = sort)
    }
}