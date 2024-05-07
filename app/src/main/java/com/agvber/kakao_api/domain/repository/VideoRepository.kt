package com.agvber.kakao_api.domain.repository

import com.agvber.kakao_api.domain.model.Sort
import com.agvber.kakao_api.domain.model.Video

interface VideoRepository {

    suspend fun getVide(
        query: String,
        sort: Sort = Sort.ACCURACY,
    ): List<Video>
}