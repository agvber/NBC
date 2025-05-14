package com.nbc.search_image.mapper

import com.nbc.search_image.database.model.RecentSearchQueryEntity
import com.nbc.search_image.domain.model.RecentSearchQuery

fun RecentSearchQueryEntity.asExternalModel(): RecentSearchQuery =
    RecentSearchQuery(
        query = queried,
        queriedDate = queriedDate
    )