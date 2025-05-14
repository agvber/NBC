package com.nbc.search_image.network.retrofit

import com.nbc.search_image.network.NetworkDataSource
import com.nbc.search_image.network.model.ImageResponse
import com.nbc.search_image.network.model.NetworkImageSort
import com.nbc.search_image.network.model.toRequestString
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject
import javax.inject.Singleton

private const val BASE_URL = "https://dapi.kakao.com"

@Singleton
internal class RetrofitNetwork @Inject constructor(
    callFactory: Call.Factory,
) : NetworkDataSource {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .callFactory(callFactory)
        .build()

    private val networkApi: NetworkApi = retrofit.create()

    override suspend fun getImages(
        query: String,
        sort: NetworkImageSort,
        page: Int,
        size: Int,
    ): ImageResponse {
        return networkApi.getImages(
            query = query,
            sort = sort.toRequestString(),
            page = page,
            size = size
        )
    }
}