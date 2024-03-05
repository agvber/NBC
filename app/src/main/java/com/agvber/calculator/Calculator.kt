package com.agvber.calculator

class Calculator(
    private val addOperation: AbstractOperation,
    private val substractOperation: AbstractOperation,
    private val multiplyOperation: AbstractOperation,
    private val divideOperation: AbstractOperation
) {

    fun add(number: Long, other: Long): Long {
        return addOperation.calculator(number, other)
    }

    fun minus(number: Long, other: Long): Long {
        return substractOperation.calculator(number, other)
    }

    fun divide(number: Long, other: Long): Long {
        return divideOperation.calculator(number, other)
    }

    fun times(number: Long, other: Long): Long {
        return multiplyOperation.calculator(number, other)
    }

    fun remain(number: Long, other: Long): Long {
        return number % other
    }
}