package com.nbc.search_image.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "search",
)
data class SearchEntity(
    @PrimaryKey
    var id: String = "",
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "date_time")
    val dateTime: String,
    @Embedded
    val image: ImageResourceEntity,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean,
) {
    init {
        id = image.thumbnailUrl.split("/").last()
    }
}