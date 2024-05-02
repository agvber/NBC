package com.agvber.kiosk.model.Beer

class Asahi: Beer() {

    override val name: String = "Asahi"
    override val price: Int = 19000

    override fun displayInfo(): String {
        return "갓 따른 생맥주 같은 부드러운 거품과 목 넘김!"
    }
}