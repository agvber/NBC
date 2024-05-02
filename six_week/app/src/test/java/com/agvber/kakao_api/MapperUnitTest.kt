package com.agvber.kakao_api

import com.agvber.kakao_api.data.repository.asExternalModel
import com.agvber.kakao_api.fake.fakeImageResponse
import com.agvber.kakao_api.network.model.ImageResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Before
import org.junit.Test

class MapperUnitTest {

    private lateinit var gson: Gson

    @Before
    fun init() {
        gson = GsonBuilder().run {
            setPrettyPrinting()
            create()
        }
    }

    @Test
    fun `이미지DTO 매핑 테스트`() {
        val response = gson.fromJson(fakeImageResponse, ImageResponse::class.java)
        println(response.asExternalModel())
    }
}