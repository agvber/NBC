package com.agvber.kiosk.model.Beer

class Cass: Beer() {

    override val name: String = "Cass"
    override val price: Int = 29000

    override fun displayInfo(): String {
        return "신나기만 했던 여름은? 바로 오늘!"
    }
}