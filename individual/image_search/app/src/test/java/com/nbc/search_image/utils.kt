package com.nbc.search_image

import com.google.gson.GsonBuilder

private val gson = GsonBuilder().run {
    setPrettyPrinting()
    create()
}

fun printPrettyJson(src: Any?) {
    println(gson.toJson(src))
}