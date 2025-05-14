package com.agvber.kakao_api.domain.repository

import com.agvber.kakao_api.domain.model.Image
import com.agvber.kakao_api.domain.model.Sort

interface ImageRepository {

    suspend fun getImage(
        query: String,
        sort: Sort = Sort.ACCURACY,
    ): List<Image>
}