package com.agvber.kakao_api.network.di

import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.retrofit.RetrofitNetwork

object NetworkModule {

    fun provideNetworkDataSource(): NetworkDataSource = RetrofitNetwork()
}