package com.nbc.search_image

import com.nbc.search_image.network.NetworkDataSource
import com.nbc.search_image.network.di.NetworkModule
import com.nbc.search_image.network.retrofit.RetrofitNetwork
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class NetworkUnitTest {

    private lateinit var networkDataSource: NetworkDataSource

    @Before
    fun init() {
        networkDataSource = RetrofitNetwork(
            NetworkModule.providesCallFactory()
        )
    }

    @Test
    fun `카카오 api 이미지 테스트`() {
        runTest {
            val response = networkDataSource.getImages("카카오톡", size = 10, page = 2)
            printPrettyJson(response)
        }
    }
}