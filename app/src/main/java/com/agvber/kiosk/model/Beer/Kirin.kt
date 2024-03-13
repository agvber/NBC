package com.agvber.kiosk.model.Beer

class Kirin: Beer() {

    override val name: String = "Kirin"
    override val price: Int = 29000

    override fun displayInfo(): String {
        return "라벨을 보면 맛이 보인다 보리 100%의 첫즙만 담은 단 하나의 맛"
    }
}