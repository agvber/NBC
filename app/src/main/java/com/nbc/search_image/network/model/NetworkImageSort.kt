package com.nbc.search_image.network.model

enum class NetworkImageSort {
    ACCURACY, RECENCY
}

fun NetworkImageSort.toRequestString(): String =
    when (this) {
        NetworkImageSort.ACCURACY -> "accuracy"
        NetworkImageSort.RECENCY -> "recency"
    }