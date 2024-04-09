package com.agvber.apple_market.data

import com.agvber.apple_market.model.Post

interface PreviewDataSource {

    fun getItem(): List<Post>
}