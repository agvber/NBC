package com.nbc.search_image.database.model

import androidx.room.ColumnInfo

data class ImageResourceEntity(
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String,
    @ColumnInfo(name = "original_url")
    val originalUrl: String,
)
