package com.agvber.kakao_api.domain.model

import java.time.LocalDateTime

data class Video(
    val title: String,
    val sourceUrl: String,
    val thumbnailUrl: String,
    val dateTime: LocalDateTime,
)