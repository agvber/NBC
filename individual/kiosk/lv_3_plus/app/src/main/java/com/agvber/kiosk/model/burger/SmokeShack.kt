package com.agvber.kiosk.model.burger

class SmokeShack : Hamburger() {

    override val name: String
        get() = "SmokeShack"
    override val price: Int
        get() = 89000

    override fun displayInfo(): String {
        return "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
    }

    fun getSmoke(): String {
        return "스목스목"
    }
}