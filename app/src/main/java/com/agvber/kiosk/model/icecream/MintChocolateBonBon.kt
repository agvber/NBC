package com.agvber.kiosk.model.icecream

class MintChocolateBonBon: IceCream() {

    override val name: String = "Mint Chocolate BonBon"
    override val price: Int = 29000

    override fun displayInfo(): String {
        return "민트 아이스크림에 달콤한 초콜릿칩과 봉봉 프레첼 볼이 가득!"
    }
}