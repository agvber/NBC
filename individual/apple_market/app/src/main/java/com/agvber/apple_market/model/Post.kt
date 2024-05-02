package com.agvber.apple_market.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
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
): Parcelable