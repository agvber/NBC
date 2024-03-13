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
                .also { require((0..4).contains(it)) }

            checkBurgersMenu(orderNumber)
            checkFrozenCustardMenu(orderNumber)
            checkDrinksMenu(orderNumber)
            checkBeerMenu(orderNumber)

            orderNumber
        }
    }

    private fun checkBurgersMenu(number: Int) {
        if (number != 1) return
        loop(0) {
            inputView.inputBurgersMenu().toInt()
                .also { require((0..4).contains(it)) }
        }
    }

    private fun checkFrozenCustardMenu(number: Int) {
        if (number != 2) return
        loop(0) {
            inputView.inputFrozenCustardMenu().toInt()
                .also { require((0..4).contains(it)) }
        }
    }

    private fun checkDrinksMenu(number: Int) {
        if (number != 3) return
        loop(0) {
            inputView.inputDrinksMenu().toInt()
                .also { require((0..4).contains(it)) }
        }
    }

    private fun checkBeerMenu(number: Int) {
        if (number != 4) return
        loop(0) {
            inputView.inputBeerMenu().toInt()
                .also { require((0..4).contains(it)) }
        }
    }
}

private fun loop(
    breakNumber: Int,
    last: (() -> Unit)? = null,
    view: () -> Int,
) {
    while (true) {
        try {
            if (view() == breakNumber) {
                if (last != null) {
                    last()
                }
                break
            }
        } catch (e: Exception) {
            println("번호를 잘 못 입력하셨습니다.")
            continue
        }
    }
}