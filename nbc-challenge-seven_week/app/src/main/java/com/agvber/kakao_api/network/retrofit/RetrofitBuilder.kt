package com.agvber.kakao_api.network.retrofit

import com.agvber.kakao_api.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

internal object RetrofitBuilder {

    private const val BASE_URL = "https://dapi.kakao.com"

    private val okhttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            }
        )
        .addInterceptor {
            with(it) {
                val request = request().newBuilder()
                    .addHeader(
                        "Authorization", "KakaoAK ${BuildConfig.KAKO_API_KEY}"
                    )
                    .build()

                proceed(request)
            }
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .callFactory(okhttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val networkApi: NetworkApi = retrofit.create()

    fun getInstance(): NetworkApi {
        return networkApi
    }

}