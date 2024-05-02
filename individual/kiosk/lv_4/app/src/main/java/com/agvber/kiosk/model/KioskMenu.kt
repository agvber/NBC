package com.agvber.kiosk.model

interface KioskMenu {

    val name: String
    val price: Int

    fun displayInfo(): String
}