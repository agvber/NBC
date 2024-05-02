package com.agvber.kakao_api.model

import java.time.OffsetDateTime

data class Images(
    val totalCount: Int,
    val pageableCount: Int,
    val isEnd: Boolean,
    val items: List<Item>
) {

    data class Item(
        val collection: String,
        val imageUrl: ImageUrl,
        val size: Size,
        val site: Site,
        val datetime: OffsetDateTime
    ) {

        data class ImageUrl(
            val thumbnail: String,
            val image: String
        )

        data class Size(
            val width: Int,
            val height: Int
        )

        data class Site(
            val name: String,
            val url: String
        )
    }
}