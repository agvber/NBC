package com.agvber.kakao_api.network.retrofit

import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.model.ImageResponse
import com.agvber.kakao_api.network.model.NetworkSort
import com.agvber.kakao_api.network.model.VideoResponse
import com.agvber.kakao_api.network.model.asExternalBodyString

internal class RetrofitNetwork : NetworkDataSource {

    private val networkApi = RetrofitBuilder.getInstance()

    override suspend fun getImages(
        query: String,
        sort: NetworkSort,
        page: Int,
        size: Int,
    ): ImageResponse {
        return networkApi.getImages(
            query = query,
            sort = sort.asExternalBodyString(),
            page = page,
            size = size
        )
    }

    override suspend fun getVideos(
        query: String,
        sort: NetworkSort,
        page: Int,
        size: Int,
    ): VideoResponse {
        return networkApi.getVideos(
            query = query,
            sort = sort.asExternalBodyString(),
            page = page,
            size = size
        )
    }
}