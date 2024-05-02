package com.agvber.kakao_api

import com.google.gson.GsonBuilder

private val gson = GsonBuilder().run {
    setPrettyPrinting()
    create()
}

internal fun printPrettyJson(src: Any?) {
    println(gson.toJson(src))
}