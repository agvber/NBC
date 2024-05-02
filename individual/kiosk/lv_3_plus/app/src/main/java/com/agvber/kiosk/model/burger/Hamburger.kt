package com.agvber.kiosk.model.burger

import com.agvber.kiosk.model.KioskMenu

open class Hamburger: KioskMenu {

    override val name: String = "Hamburger"
    override val price: Int = 54000

    override fun displayInfo(): String {
        return "비프패티를 기반으로 야채가 들어간 기본버거"
    }
}