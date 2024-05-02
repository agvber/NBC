package com.agvber.kiosk.controller

import com.agvber.kiosk.model.Beer.Asahi
import com.agvber.kiosk.model.Beer.Cass
import com.agvber.kiosk.model.Beer.Terra
import com.agvber.kiosk.model.KioskMenu
import com.agvber.kiosk.model.burger.Cheeseburger
import com.agvber.kiosk.model.burger.Hamburger
import com.agvber.kiosk.model.burger.ShackBurger
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
import kotlin.random.Random
import kotlin.random.nextInt

class KioskController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val menus: MutableList<KioskMenu>
) {
    
    fun run() {
        val money = showMeTheMoney()
        var isRunning = true
        while (isRunning) {
            outputView.printMoney(money)

            runCatching { inputView.inputInitMenu().toInt() }
                .onFailure {
                    outputView.printNumberError()
                }
                .onSuccess { orderNumber ->
                    if (orderNumber == 0) {
                        outputView.shutdownProgram()
                        isRunning = false
                    }

                    checkInitMenu(orderNumber)
                    checkBurgersMenu(orderNumber)
                    checkFrozenCustardMenu(orderNumber)
                    checkDrinksMenu(orderNumber)
                    checkBeerMenu(orderNumber)
                }
        }
    }

    private fun showMeTheMoney(): Int {
        val range = 12000..69000
        val random = Random.nextInt(range)
        return random
    }

    private fun checkInitMenu(number: Int) {
        require((0..4).contains(number))
    }

    private fun checkBurgersMenu(number: Int) {
        if (number != 1) return

        while (true) {
            try {
                val order = inputView.inputBurgersMenu().toInt()
                when (order) {
                    0 -> {}
                    1 -> menus.add(ShackBurger())
                    2 -> menus.add(SmokeShack())
                    3 -> menus.add(Cheeseburger())
                    4 -> menus.add(Hamburger())
                    else -> throw IllegalArgumentException()
                }
                break
            } catch (e: Exception) {
                outputView.printNumberError()
            }
        }
    }

    private fun checkFrozenCustardMenu(number: Int) {
        if (number != 2) return

        while (true) {
            try {
                val order = inputView.inputFrozenCustardMenu().toInt()
                when (order) {
                    0 -> {}
                    1 -> menus.add(StrawberryCandyIceCream())
                    2 -> menus.add(BonjourMacaron())
                    3 -> menus.add(PeachYogurt())
                    4 -> menus.add(MintChocolateBonBon())
                    5 -> menus.add(MangoTango())
                    else -> throw IllegalArgumentException()
                }
                break
            } catch (e: Exception) {
                outputView.printNumberError()
            }
        }
    }

    private fun checkDrinksMenu(number: Int) {
        if (number != 3) return

        while (true) {
            try {
                val order = inputView.inputDrinksMenu().toInt()
                when (order) {
                    0 -> {}
                    1 -> menus.add(Coke())
                    2 -> menus.add(Sprite())
                    3 -> menus.add(Cider())
                    4 -> menus.add(Fanta())
                    5 -> menus.add(DrPepper())
                    else -> throw IllegalArgumentException()
                }
                break
            } catch (e: Exception) {
                outputView.printNumberError()
            }
        }
    }

    private fun checkBeerMenu(number: Int) {
        if (number != 4) return

        while (true) {
            try {
                val order = inputView.inputBeerMenu().toInt()
                when (order) {
                    0 -> {}
                    1 -> menus.add(Asahi())
                    2 -> menus.add(Cass())
                    3 -> menus.add(Cider())
                    4 -> menus.add(Fanta())
                    5 -> menus.add(Terra())
                    else -> throw IllegalArgumentException()
                }
                break
            } catch (e: Exception) {
                outputView.printNumberError()
            }
        }
    }
}