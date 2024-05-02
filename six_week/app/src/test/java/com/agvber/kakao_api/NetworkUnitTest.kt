package com.agvber.kakao_api

import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.retrofit.RetrofitNetwork
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkUnitTest {

    private val networkDataSource: NetworkDataSource = RetrofitNetwork()

    @Test fun`카카오 api 이미지 테스트`() {
        runTest {
            val response = networkDataSource.getImages("카카오톡")
            printPrettyJson(response)
        }
    }
}