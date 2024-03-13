package com.agvber.kiosk.model.burger

class ShackBurger : Hamburger() {

    override val name: String
        get() = "ShackBurger"

    override val price: Int
        get() = 69000

    override fun displayInfo(): String {
        return "토마토, 양상추, 쉑소스가 토핑된 치즈버거"
    }

    fun getShack(): String {
        return "쉑쉑"
    }
}