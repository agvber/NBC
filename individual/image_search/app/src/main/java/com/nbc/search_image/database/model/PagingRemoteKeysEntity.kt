package com.nbc.search_image.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paging_remote_keys")
data class PagingRemoteKeysEntity(
    @PrimaryKey
    val queried: String,
    @ColumnInfo(name = "prev_key")
    val prevKey: Int?,
    @ColumnInfo(name = "nex_key")
    val nextKey: Int?,
    @ColumnInfo(name = "current_key")
    val currentKey: Int?
)