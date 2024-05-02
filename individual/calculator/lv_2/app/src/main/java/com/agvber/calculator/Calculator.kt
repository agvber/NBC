package com.agvber.calculator

class Calculator {

    fun add(number: Long, other: Long): Long {
        return number + other
    }

    fun minus(number: Long, other: Long): Long {
        return number - other
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