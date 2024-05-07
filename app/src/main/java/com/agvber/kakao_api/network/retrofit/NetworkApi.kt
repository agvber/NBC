package com.agvber.kakao_api.network.retrofit

import androidx.annotation.IntRange
import com.agvber.kakao_api.network.model.ImageResponse
import com.agvber.kakao_api.network.model.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NetworkApi {

    @GET("/v2/search/image")
    suspend fun getImages(
        @Query("query") query: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") @IntRange(1, 50) page: Int = 1,
        @Query("size") @IntRange(1, 80) size: Int = 80,
    ): ImageResponse

    @GET("/v2/search/vclip")
    suspend fun getVideos(
        @Query("query") query: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") @IntRange(1, 15) page: Int = 1,
        @Query("size") @IntRange(1, 30) size: Int = 15,
    ): VideoResponse
}