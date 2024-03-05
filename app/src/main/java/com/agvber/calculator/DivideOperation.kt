package com.agvber.calculator

class DivideOperation : AbstractOperation() {

    override fun calculator(number: Long, other: Long): Long {
        return number / other
    }
}