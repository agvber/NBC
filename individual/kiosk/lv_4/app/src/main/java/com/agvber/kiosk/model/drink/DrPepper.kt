package com.agvber.kiosk.model.drink

class DrPepper: Drink() {

    override val name: String = "Dr Pepper"
    override val price: Int = 14000

    override fun displayInfo(): String {
        return "1885년 탄생한 닥터페퍼는 독특한 맛과 톡 쏘는 탄산으로 마실수록 빠져드는 경험을 선사합니다."
    }
}