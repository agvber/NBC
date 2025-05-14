package com.nbc.search_image.mapper

import com.nbc.search_image.database.model.SearchEntity
import com.nbc.search_image.domain.model.Image
import com.nbc.search_image.domain.model.Search
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal fun SearchEntity.asExternalModel(): Search {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    val localDateTime = LocalDateTime.parse(dateTime, formatter)

    return Search(
        id = id,
        title = title,
        dateTime = localDateTime,
        image = Image(
            image.thumbnailUrl,
            image.originalUrl
        ),
        isFavorite = isFavorite
    )
}