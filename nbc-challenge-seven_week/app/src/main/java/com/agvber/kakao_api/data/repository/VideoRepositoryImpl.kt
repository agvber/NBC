package com.agvber.kakao_api.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.agvber.kakao_api.data.paging.VideoPagingSource
import com.agvber.kakao_api.domain.model.Sort
import com.agvber.kakao_api.domain.model.Video
import com.agvber.kakao_api.domain.repository.VideoRepository
import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.model.VideoResponse
import com.agvber.kakao_api.network.model.asNetworkModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class VideoRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
) : VideoRepository {

    override suspend fun getVide(
        query: String,
        sort: Sort,
    ): List<Video> {
        return networkDataSource
            .getVideos(query = query, sort = sort.asNetworkModel(), size = 30, page = 1)
            .documents.map { it.asExternalModel() }
    }
}

private fun VideoResponse.Document.asExternalModel(): Video =
    Video(
        title = title,
        sourceUrl = url,
        thumbnailUrl = thumbnail,
        dateTime = LocalDateTime.from(
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(datetime)
        )
    )
