package com.agvber.kiosk.model.burger

class Cheeseburger : Hamburger() {

    override val name: String
        get() = "Cheeseburger"

    override val price: Int
        get() = 69000

    override fun displayInfo(): String {
        return "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"
    }

    fun getCheese(): String {
        return "쭈르르륵"
    }
}