package com.nbc.search_image.network.di

import com.nbc.search_image.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import javax.inject.Singleton

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
                            "Authorization", "KakaoAK ${BuildConfig.KAKO_API_KEY}"
                        )
                        .build()

                    proceed(request)
                }
            }
            .build()
}