package com.agvber.kiosk.model.Beer

class Kelly: Beer() {

    override val name: String = "Kelly"
    override val price: Int = 24000

    override fun displayInfo(): String {
        return "첫맛은 부드럽게 끝맛은 강렬하게"
    }
}