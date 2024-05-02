package com.agvber.kakao_api.network.retrofit

import androidx.annotation.IntRange
import com.agvber.kakao_api.network.model.ImageResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NetworkApi {

    @GET("/v2/search/image")
    suspend fun getImages(
        @Query("query") query: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") @IntRange(1, 50) page: Int = 1,
        @Query("size") @IntRange(1, 80) size: Int = 80
    ): ImageResponse
}