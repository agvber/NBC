package com.nbc.search_image.network

import androidx.annotation.IntRange
import com.nbc.search_image.network.model.ImageResponse
import com.nbc.search_image.network.model.NetworkImageSort

interface NetworkDataSource {

    suspend fun getImages(
        query: String,
        sort: NetworkImageSort = NetworkImageSort.ACCURACY,
        @IntRange(1, 50) page: Int = 1,
        @IntRange(1, 80) size: Int = 80
    ): ImageResponse
}