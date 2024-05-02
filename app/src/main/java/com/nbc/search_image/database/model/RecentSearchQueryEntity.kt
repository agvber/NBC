package com.nbc.search_image.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "recent_search_query"
)
data class RecentSearchQueryEntity(
    @PrimaryKey
    val queried: String,
    @ColumnInfo("queried_date")
    val queriedDate: Long, // Unix Time
)