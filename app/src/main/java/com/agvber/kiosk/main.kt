package com.agvber.kiosk

import com.agvber.kiosk.controller.KioskController
import com.agvber.kiosk.view.InputView

fun main(array: Array<String>) {
    val inputView = InputView()
    KioskController(inputView).run()
}
