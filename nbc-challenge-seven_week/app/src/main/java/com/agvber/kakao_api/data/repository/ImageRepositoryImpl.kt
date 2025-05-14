package com.agvber.kakao_api.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.agvber.kakao_api.data.paging.ImagePagingSource
import com.agvber.kakao_api.domain.model.Image
import com.agvber.kakao_api.domain.model.Sort
import com.agvber.kakao_api.domain.repository.ImageRepository
import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.model.ImageResponse
import com.agvber.kakao_api.network.model.asNetworkModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class ImageRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
) : ImageRepository {

    override suspend fun getImage(
        query: String,
        sort: Sort,
    ): List<Image> {

        return networkDataSource
            .getImages(query = query, sort = sort.asNetworkModel(), page = 1, size = 30)
            .documents.map { it.asExternalModel() }
    }
}

private fun ImageResponse.Document.asExternalModel(): Image =
    Image(
        title = displaySiteName,
        content = collection,
        imageUrl = imageUrl,
        thumbnailUrl = thumbnailUrl,
        dateTime = LocalDateTime.from(
            DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(datetime)
        )
    )