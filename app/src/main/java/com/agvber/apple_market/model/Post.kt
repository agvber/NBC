package com.agvber.apple_market.model

import androidx.annotation.DrawableRes

data class Post(
    val number: Long,
    @DrawableRes val image: Int,
    val name: String,
    val description: String,
    val seller: String,
    val price: Long,
    val address: String,
    val like: Long,
    val chat: Long
)