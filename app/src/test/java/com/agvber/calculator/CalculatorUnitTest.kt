package com.agvber.calculator

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class CalculatorUnitTest {

    private lateinit var calculator: Calculator

    @Before
    fun init() {
        val addOperation: AbstractOperation = AddOperation()
        val substractOperation: AbstractOperation = SubstractOperation()
        val multiplyOperation: AbstractOperation = MultiplyOperation()
        val divideOperation: AbstractOperation = DivideOperation()

        calculator = Calculator(
            addOperation = addOperation,
            substractOperation = substractOperation,
            multiplyOperation = multiplyOperation,
            divideOperation = divideOperation
        )
    }

    @Test
    fun `더하기 테스트`() {
        val result = calculator.add(5, 3)
        Assert.assertEquals(result, 8)
    }

    @Test
    fun `뺄셈 테스트`() {
        val result = calculator.minus(5, 3)
        Assert.assertEquals(result, 2)
    }

    @Test
    fun `나눗셈 테스트`() {
        val result = calculator.divide(4, 2)
        Assert.assertEquals(result, 2)
    }

    @Test
    fun `곰셈 테스트`() {
        val result = calculator.times(12, 12)
        Assert.assertEquals(result, 144)
    }

    @Test
    fun `나머지 테스트`() {
        val result = calculator.remain(10, 2)
        Assert.assertEquals(result, 0)
    }

    @Test
    fun `추가 연산 테스트`() {
        val add = calculator.add(5, 5)
        val times = calculator.times(add, 10)
        Assert.assertEquals(times, 100)
    }

    @Test
    @Synchronized
    fun `무한 반복문 계산 테스트`() { // 이게 맞을까???
        var number = 0L
        while (true) {
            number += calculator.add(1, 1)
            println(number)
        }
    }
}