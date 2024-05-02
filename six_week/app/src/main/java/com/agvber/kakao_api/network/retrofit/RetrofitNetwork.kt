package com.agvber.kakao_api.network.retrofit

import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.model.ImageResponse
import com.agvber.kakao_api.network.model.ImageSort

internal class RetrofitNetwork: NetworkDataSource {

    private val networkApi = RetrofitBuilder.getInstance()

    override suspend fun getImages(
        query: String,
        sort: ImageSort,
        page: Int,
        size: Int,
    ): ImageResponse {
        val networkSort = when (sort) {
            ImageSort.ACCURACY -> "accuracy"
            ImageSort.RECENCY -> "recency"
        }

        return networkApi.getImages(
            query = query,
            sort = networkSort,
            page = page,
            size = size
        )
    }
}