package com.agvber.kiosk

import com.agvber.kiosk.controller.KioskController
import com.agvber.kiosk.view.InputView
import com.agvber.kiosk.view.OutputView

fun main(array: Array<String>) {
    val inputView = InputView()
    val outputView = OutputView()

    KioskController(inputView, outputView).run()
}
