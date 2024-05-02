package com.agvber.kiosk.model.drink

import com.agvber.kiosk.model.KioskMenu

abstract class Drink: KioskMenu {

    abstract override val name: String
    abstract override val price: Int

    abstract override fun displayInfo(): String
}