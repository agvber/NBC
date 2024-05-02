package com.agvber.kakao_api.network

import androidx.annotation.IntRange
import com.agvber.kakao_api.network.model.ImageResponse
import com.agvber.kakao_api.network.model.ImageSort

interface NetworkDataSource {

    suspend fun getImages(
        query: String,
        sort: ImageSort = ImageSort.ACCURACY,
        @IntRange(1, 50) page: Int = 1,
        @IntRange(1, 80) size: Int = 80
    ): ImageResponse
}