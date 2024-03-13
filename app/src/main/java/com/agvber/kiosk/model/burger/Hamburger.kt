package com.agvber.kiosk.model.burger

open class Hamburger {

    open val name: String = "Hamburger"
    open val price: Int = 54000

    open fun displayInfo(): String {
        return "비프패티를 기반으로 야채가 들어간 기본버거"
    }
}