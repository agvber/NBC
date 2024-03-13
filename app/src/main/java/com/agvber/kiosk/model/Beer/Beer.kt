package com.agvber.kiosk.model.Beer

abstract class Beer {

    abstract val name: String
    abstract val price: Int

    abstract fun displayInfo(): String
}