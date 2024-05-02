package com.nbc.search_image.domain.model

data class RecentSearchQuery(
    val query: String,
    val queriedDate: Long = System.currentTimeMillis(),
)