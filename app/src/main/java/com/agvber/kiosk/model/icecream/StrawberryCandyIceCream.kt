package com.agvber.kiosk.model.icecream

class StrawberryCandyIceCream: IceCream() {

    override val name: String = "Strawberry Candy Ice cream"
    override val price: Int = 59000

    override fun displayInfo(): String {
        return "상큼한 딸기 소르베&달콤한 딸기 아이스크림에 딸기 리본과 크리스탈 슈가, 팝핑 캔디가 톡톡"
    }
}