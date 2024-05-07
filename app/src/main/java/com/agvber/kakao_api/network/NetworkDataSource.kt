package com.agvber.kakao_api.network

import androidx.annotation.IntRange
import com.agvber.kakao_api.network.model.ImageResponse
import com.agvber.kakao_api.network.model.NetworkSort
import com.agvber.kakao_api.network.model.VideoResponse

interface NetworkDataSource {

    suspend fun getImages(
        query: String,
        sort: NetworkSort = NetworkSort.ACCURACY,
        @IntRange(1, 50) page: Int = 1,
        @IntRange(1, 80) size: Int = 80,
    ): ImageResponse

    suspend fun getVideos(
        query: String,
        sort: NetworkSort = NetworkSort.ACCURACY,
        @IntRange(1, 15) page: Int = 1,
        @IntRange(1, 30) size: Int = 15,
    ): VideoResponse
}