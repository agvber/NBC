package com.nbc.search_image.mapper

import com.nbc.search_image.database.model.BookmarkEntity
import com.nbc.search_image.domain.model.Bookmark
import com.nbc.search_image.domain.model.Image
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun BookmarkEntity.asExternalModel(): Bookmark {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val localDateTime = LocalDateTime.parse(dateTime, formatter)

    return Bookmark(
        id = id,
        title = title,
        dateTime = localDateTime,
        image = Image(image.thumbnailUrl, image.originalUrl)
    )
}