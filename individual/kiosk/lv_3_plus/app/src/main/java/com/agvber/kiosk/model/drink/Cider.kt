package com.agvber.kiosk.model.drink

class Cider: Drink() {

    override val name: String = "Cider"
    override val price: Int = 24000

    override fun displayInfo(): String {
        return "칠성사이다는 반세기 이상의 역사를 지닌 대한민국 No.1 오리지널 탄산음료입니다. 청량감이 느껴지는 탄산과 상큼한 레몬라임향이 특징입니다."
    }
}