package com.nbc.search_image.network.di

import com.nbc.search_image.network.NetworkDataSource
import com.nbc.search_image.network.retrofit.RetrofitNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RetrofitModule {

    @Binds
    @Singleton
    fun bindsRetrofitNetwork(
        retrofitNetwork: RetrofitNetwork,
    ): NetworkDataSource
}