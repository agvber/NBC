package com.agvber.kiosk.model.Beer

import com.agvber.kiosk.model.KioskMenu

abstract class Beer: KioskMenu {

    abstract override val name: String
    abstract override val price: Int

    abstract override fun displayInfo(): String
}