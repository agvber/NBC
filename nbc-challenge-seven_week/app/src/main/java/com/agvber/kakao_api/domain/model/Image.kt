package com.agvber.kakao_api.domain.model

import java.time.LocalDateTime

data class Image(
    val title: String,
    val content: String,
    val imageUrl: String,
    val thumbnailUrl: String,
    val dateTime: LocalDateTime,
)