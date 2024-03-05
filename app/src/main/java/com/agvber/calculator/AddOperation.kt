package com.agvber.calculator

class AddOperation : AbstractOperation() {

    override fun calculator(number: Long, other: Long): Long {
        return number + other
    }
}