package com.agvber.kiosk.view

class OutputView {

    fun shutdownProgram() {
        println("프로그램을 종료합니다.")
    }

    fun printNumberError() {
        println("번호를 잘못 입력하셨습니다")
        println("다시 입력하여주세요.")
    }

    fun printMoney(money: Int) {
        println("현재 잔액은: ${money}원 입니다.")
    }
}