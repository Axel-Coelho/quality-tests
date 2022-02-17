package com.teaching.project.banking.domain;

data class Bank(val accounts: MutableMap<String, Account> = mutableMapOf()) {

    fun register(account: Account) {
    }

    fun transfer(sender: Account, receiver: Account, amount: Double) {}

    fun dashboard() {
        print(this)
    }


}
