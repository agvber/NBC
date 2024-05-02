package com.agvber.kiosk.model.icecream

class MangoTango: IceCream() {

    override val name: String = "Mango Tango"
    override val price: Int = 34000

    override fun displayInfo(): String {
        return "부드럽고 상큼한 열대과일, 입 안 가득 진한 망고 향이 가득!"
    }
}