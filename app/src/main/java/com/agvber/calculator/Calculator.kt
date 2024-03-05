package com.agvber.calculator

class Calculator {

    private val addOperation by lazy(LazyThreadSafetyMode.NONE) {
        AddOperation()
    }

    private val substractOperation by lazy(LazyThreadSafetyMode.NONE) {
        SubstractOperation()
    }

    fun add(number: Long, other: Long): Long {
        return addOperation.calculator(number, other)
    }

    fun minus(number: Long, other: Long): Long {
        return substractOperation.calculator(number, other)
    }

    fun divide(number: Long, other: Long): Long {
        return number / other
    }

    fun times(number: Long, other: Long): Long {
        return number * other
    }

    fun remain(number: Long, other: Long): Long {
        return number % other
    }
}