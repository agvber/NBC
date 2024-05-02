package com.agvber.kiosk.controller

import com.agvber.kiosk.view.InputView
import com.agvber.kiosk.view.OutputView

class KioskController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    
    fun run() {
        loop(
            breakNumber = 0,
            last = {
                outputView.shutdownProgram()
            }
        ) {
            val orderNumber = inputView.inputInitMenu().toInt()

            checkBurgersMenu(orderNumber)
            checkFrozenCustardMenu(orderNumber)
            checkDrinksMenu(orderNumber)
            checkBeerMenu(orderNumber)

            orderNumber
        }
    }

    private fun checkBurgersMenu(number: Int) {
        if (number != 1) return
        loop(0) { inputView.inputBurgersMenu().toInt() }
    }

    private fun checkFrozenCustardMenu(number: Int) {
        if (number != 2) return
        loop(0) { inputView.inputFrozenCustardMenu().toInt() }
    }

    private fun checkDrinksMenu(number: Int) {
        if (number != 3) return
        loop(0) { inputView.inputDrinksMenu().toInt() }
    }

    private fun checkBeerMenu(number: Int) {
        if (number != 4) return
        loop(0) { inputView.inputBeerMenu().toInt() }
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