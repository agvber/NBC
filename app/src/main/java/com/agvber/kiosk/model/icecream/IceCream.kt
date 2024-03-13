package com.agvber.kiosk.model.icecream

import com.agvber.kiosk.model.KioskMenu

abstract class IceCream: KioskMenu {

    abstract override val name: String
    abstract override val price: Int

    abstract override fun displayInfo() : String
}