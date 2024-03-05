package com.agvber.calculator

class MultiplyOperation : AbstractOperation() {

    override fun calculator(number: Long, other: Long): Long {
        return number * other
    }
}