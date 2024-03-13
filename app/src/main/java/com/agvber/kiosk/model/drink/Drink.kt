package com.agvber.kiosk.model.drink

abstract class Drink {

    abstract val name: String
    abstract val price: Int

    abstract fun displayInfo(): String
}