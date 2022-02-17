package com.teaching.project.banking.domain

data class Account(val iban: String, var balance: Double = 0.0) {

    init {
        // initialization
    }

    fun deposit(amount: Double) {}

    fun withdraw(amount: Double) {}

    fun transfer(receiver: Account, amount: Double){
    }

}