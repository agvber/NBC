package com.agvber.kakao_api.network.model

import com.google.gson.annotations.SerializedName

// https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-video-response

data class VideoResponse(
    @SerializedName("meta") val meta: Meta,
    @SerializedName("documents") val documents: List<Document>
) {

    data class Meta(
        @SerializedName("total_count") val totalCount: Int,
        @SerializedName("pageable_count") val pageableCount: Int,
        @SerializedName("is_end") val isEnd: Boolean
    )

    data class Document(
        @SerializedName("title") val title: String,
        @SerializedName("url") val url: String,
        @SerializedName("datetime") val datetime: String,
        @SerializedName("play_time") val playTime: Int,
        @SerializedName("thumbnail") val thumbnail: String,
        @SerializedName("author") val author: String,
    )
}
