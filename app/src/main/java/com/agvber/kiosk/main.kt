package com.agvber.kiosk

import com.agvber.kiosk.controller.KioskController
import com.agvber.kiosk.model.Beer.Asahi
import com.agvber.kiosk.model.Beer.Cass
import com.agvber.kiosk.model.Beer.Kelly
import com.agvber.kiosk.model.Beer.Kirin
import com.agvber.kiosk.model.Beer.Terra
import com.agvber.kiosk.model.KioskMenu
import com.agvber.kiosk.model.burger.Cheeseburger
import com.agvber.kiosk.model.burger.Hamburger
import com.agvber.kiosk.model.burger.ShackBurger
import com.agvber.kiosk.model.burger.ShroomBurger
import com.agvber.kiosk.model.burger.SmokeShack
import com.agvber.kiosk.model.drink.Cider
import com.agvber.kiosk.model.drink.Coke
import com.agvber.kiosk.model.drink.DrPepper
import com.agvber.kiosk.model.drink.Fanta
import com.agvber.kiosk.model.drink.Sprite
import com.agvber.kiosk.model.icecream.BonjourMacaron
import com.agvber.kiosk.model.icecream.MangoTango
import com.agvber.kiosk.model.icecream.MintChocolateBonBon
import com.agvber.kiosk.model.icecream.PeachYogurt
import com.agvber.kiosk.model.icecream.StrawberryCandyIceCream
import com.agvber.kiosk.view.InputView
import com.agvber.kiosk.view.OutputView

fun main(array: Array<String>) {
    val inputView = InputView()
    val outputView = OutputView()

    KioskController(inputView, outputView).run()

    init()
}



private fun init() {
    val menus: List<KioskMenu> = listOf(
        // 버거
        Hamburger(),
        ShackBurger(),
        ShroomBurger(),
        SmokeShack(),
        Cheeseburger(),
        // 아이스크림
        BonjourMacaron(),
        MangoTango(),
        MintChocolateBonBon(),
        PeachYogurt(),
        StrawberryCandyIceCream(),
        // 음료
        Cider(),
        Coke(),
        DrPepper(),
        Fanta(),
        Sprite(),
        // 비어
        Asahi(),
        Cass(),
        Kelly(),
        Kirin(),
        Terra()
    )
}