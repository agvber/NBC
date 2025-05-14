package com.nbc.search_image.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import javax.inject.Singleton

private const val API_KEY = "9acd782890a75dd41e6a286c7acc4fbe"

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providesCallFactory(): Call.Factory =
        OkHttpClient.Builder()
            .addInterceptor {
                with(it) {
                    val request = request().newBuilder()
                        .addHeader(
                            "Authorization", "KakaoAK $API_KEY"
                        )
                        .build()

                    proceed(request)
                }
            }
            .build()
}