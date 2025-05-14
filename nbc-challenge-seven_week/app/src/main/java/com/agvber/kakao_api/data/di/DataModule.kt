package com.agvber.kakao_api.data.di

import com.agvber.kakao_api.data.repository.ImageRepositoryImpl
import com.agvber.kakao_api.data.repository.VideoRepositoryImpl
import com.agvber.kakao_api.domain.repository.ImageRepository
import com.agvber.kakao_api.domain.repository.VideoRepository
import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.di.NetworkModule
import com.agvber.kakao_api.network.retrofit.RetrofitNetwork

internal object DataModule {

    fun bindImageRepository(
        networkDataSource: NetworkDataSource = NetworkModule.provideNetworkDataSource()
    ): ImageRepository = ImageRepositoryImpl(networkDataSource)

    fun bindVideoRepository(
        networkDataSource: NetworkDataSource = NetworkModule.provideNetworkDataSource(),
    ): VideoRepository = VideoRepositoryImpl(networkDataSource)
}