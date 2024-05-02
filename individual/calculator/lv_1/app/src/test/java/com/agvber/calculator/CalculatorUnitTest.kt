package com.agvber.calculator

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class CalculatorUnitTest {

    private lateinit var calculator: Calculator

    @Before
    fun init() {
        calculator = Calculator()
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
}