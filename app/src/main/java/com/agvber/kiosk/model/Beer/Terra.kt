package com.agvber.kiosk.model.Beer

class Terra: Beer() {

    override val name: String = "TERRA"
    override val price: Int = 14000

    override fun displayInfo(): String {
        return "이 맛이 청정라거다!"
    }
}