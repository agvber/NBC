package com.agvber.kiosk.model.burger

class ShroomBurger : Hamburger() {

    override val name: String
        get() = "Shroom Burger"
    override val price: Int
        get() = 94000

    override fun displayInfo(): String {
        return "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"
    }

    fun getShroom(): String {
        return "수룸수룸"
    }
}