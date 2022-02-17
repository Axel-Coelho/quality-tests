package com.teaching.project.banking.domain

data class Account(val iban: String, var balance: Double = 0.0) {

    init {
        if (!Regex(pattern = "^FR[0-9]{25}").matches(iban)) {
            throw RuntimeException ("IBAN Invalide")
        }
    }

    fun deposit(amount: Double) {
        balance+=amount
    }

    fun withdraw(amount: Double) {
        if(balance - amount > 0){
            balance-=amount;
        }else{
            throw RuntimeException("Vous n'avez pas assez d'argent.")
        }
    }

    fun transfer(receiver: Account, amount: Double){
        if(amount > 0){
            withdraw(amount)
            receiver.deposit(amount)
        }else{
            throw RuntimeException("Votre demande de transfert est invalide.")
        }

    }

}