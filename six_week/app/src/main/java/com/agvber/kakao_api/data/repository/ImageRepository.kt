package com.agvber.kakao_api.data.repository

import androidx.annotation.IntRange
import com.agvber.kakao_api.model.Images
import com.agvber.kakao_api.network.model.ImageSort

interface ImageRepository {

    suspend fun getImage(
        query: String,
        sort: ImageSort = ImageSort.ACCURACY,
        @IntRange(1, 50) page: Int = 1,
        @IntRange(1, 80) size: Int = 80,
    ): Images
}