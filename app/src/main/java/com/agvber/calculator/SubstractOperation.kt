package com.agvber.calculator

class SubstractOperation : AbstractOperation() {

    override fun calculator(number: Long, other: Long): Long {
        return number - other
    }
}