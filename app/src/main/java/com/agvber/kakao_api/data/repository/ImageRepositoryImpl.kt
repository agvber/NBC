package com.agvber.kakao_api.data.repository

import com.agvber.kakao_api.model.Images
import com.agvber.kakao_api.network.NetworkDataSource
import com.agvber.kakao_api.network.model.ImageResponse
import com.agvber.kakao_api.network.model.ImageSort
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class ImageRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
) : ImageRepository {
    override suspend fun getImage(
        query: String,
        sort: ImageSort,
        page: Int,
        size: Int,
    ): Images {
        return networkDataSource.getImages(
            query = query, sort = sort, page = page, size = size
        )
            .asExternalModel()
    }
}

internal fun ImageResponse.asExternalModel(): Images {

    return Images(
        totalCount = meta.totalCount,
        pageableCount = meta.pageableCount,
        isEnd = meta.isEnd,
        items = documents.map {
            Images.Item(
                collection = it.collection,
                imageUrl = Images.Item.ImageUrl(
                    it.thumbnailUrl,
                    it.imageUrl
                ),
                size = Images.Item.Size(it.width, it.height),
                site = Images.Item.Site(it.displaySiteName, it.docUrl),
                datetime = OffsetDateTime.parse(
                    it.datetime,
                    DateTimeFormatter.ISO_OFFSET_DATE_TIME
                )
            )
        }
    )
}