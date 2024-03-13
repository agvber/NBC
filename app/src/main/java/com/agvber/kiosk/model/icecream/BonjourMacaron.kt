package com.agvber.kiosk.model.icecream

class BonjourMacaron: IceCream() {

    override val name: String = "Bonjour, Macaron"
    override val price: Int = 69000

    override fun displayInfo(): String {
        return "부드러운 마스카포네 아이스크림과 마카롱, 초콜릿의 달콤한 만남!"
    }
}