package com.agvber.kiosk.controller

import com.agvber.kiosk.view.InputView

class KioskController(
    private val view: InputView
) {
    
    fun run() {
        loop(
            breakNumber = 0,
            last = {
                println("프로그램을 종료합니다.")
            }
        ) {
            val orderNumber = view.inputInitMenu().toInt()

            checkBurgersMenu(orderNumber)
            checkFrozenCustardMenu(orderNumber)
            checkDrinksMenu(orderNumber)
            checkBeerMenu(orderNumber)

            orderNumber
        }
    }

    private fun checkBurgersMenu(number: Int) {
        if (number != 1) return
        loop(0) { view.inputBurgersMenu().toInt() }
    }

    private fun checkFrozenCustardMenu(number: Int) {
        if (number != 2) return
        loop(0) { view.inputFrozenCustardMenu().toInt() }
    }

    private fun checkDrinksMenu(number: Int) {
        if (number != 3) return
        loop(0) { view.inputDrinksMenu().toInt() }
    }

    private fun checkBeerMenu(number: Int) {
        if (number != 4) return
        loop(0) { view.inputBeerMenu().toInt() }
    }
}

private fun loop(
    breakNumber: Int,
    last: (() -> Unit)? = null,
    view: () -> Int,
) {
    while (true) {
        if (view() == breakNumber) {
            if (last != null) {
                last()
            }
            break
        }
    }
}