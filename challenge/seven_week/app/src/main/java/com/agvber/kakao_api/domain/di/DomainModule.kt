package com.agvber.kakao_api.domain.di

import com.agvber.kakao_api.data.di.DataModule
import com.agvber.kakao_api.domain.repository.ImageRepository
import com.agvber.kakao_api.domain.repository.VideoRepository
import com.agvber.kakao_api.domain.usecase.GetImageListUseCase
import com.agvber.kakao_api.domain.usecase.GetVideListUseCase

object DomainModule {

    fun bindGetImageListUseCase(
        imageRepository: ImageRepository = DataModule.bindImageRepository()
    ): GetImageListUseCase = GetImageListUseCase(imageRepository)

    fun bindGetVideoListUseCase(
        videoRepository: VideoRepository = DataModule.bindVideoRepository()
    ): GetVideListUseCase = GetVideListUseCase(videoRepository)

}