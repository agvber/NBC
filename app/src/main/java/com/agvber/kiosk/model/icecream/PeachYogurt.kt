package com.agvber.kiosk.model.icecream

class PeachYogurt: IceCream() {

    override val name: String = "Peach Yogurt"
    override val price: Int = 34000

    override fun displayInfo(): String {
        return "상큼한 복숭아 요거트, 복숭아 샤베트에 복숭아 과육이 가득!"
    }
}