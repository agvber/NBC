package com.agvber.kakao_api.domain.usecase

import androidx.paging.PagingData
import com.agvber.kakao_api.domain.model.Image
import com.agvber.kakao_api.domain.model.Sort
import com.agvber.kakao_api.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow

class GetImageListUseCase(
    private val imageRepository: ImageRepository
) {

    suspend operator fun invoke(
        query: String,
        sort: Sort = Sort.ACCURACY,
    ): List<Image> =
        imageRepository.getImage(query = query, sort = sort)

}