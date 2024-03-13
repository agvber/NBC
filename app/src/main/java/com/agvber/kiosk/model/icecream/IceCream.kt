package com.agvber.kiosk.model.icecream

abstract class IceCream {

    abstract val name: String
    abstract val price: Int

    abstract fun displayInfo() : String
}