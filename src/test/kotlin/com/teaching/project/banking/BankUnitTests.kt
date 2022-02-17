package com.teaching.project.banking;

import com.teaching.project.banking.domain.Account
import com.teaching.project.banking.domain.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankUnitTests {

    @Test
    fun `can deposit cash`() {
        // GIVEN
        val account = Account("FR7630001007941234567890185", 0.0)

        // WHEN
        account.deposit(8.0)

        // THEN
        Assertions.assertEquals(8.0, account.balance)
    }

    @Test
    fun `can withdraw cash`() {
        // GIVEN
        val account = Account("FR7630001007941234567890185", 10.0)

        // WHEN
        account.withdraw(8.0)

        // THEN
        Assertions.assertEquals(2.0, account.balance)
    }

    @Test
    fun `can transfer cash`() {
        // GIVEN
        val account1 = Account("FR7630001007941234567890185", 10.0)
        val account2 = Account("FR7630001007941234567870185", 20.0)

        // WHEN
        account1.transfer(account2, 8.0)

        // THEN
        Assertions.assertEquals(2.0, account1.balance)
        Assertions.assertEquals(28.0, account2.balance)
    }

    @Test
    fun `can register a new account`() {
        // GIVEN
        val bank = Bank()
        val account = Account("FR7630001007941234567890185", 0.0)

        // WHEN
        bank.register(account)

        // THEN
        Assertions.assertTrue(bank.accounts.values.containsAll(listOf(account)))
    }

    @Test
    fun `should not be allowed to withdraw more cash than available`() {
        // GIVEN
        val account = Account("FR7630001007941234567890185", 10.0)

        // WHEN
        val executable = { account.withdraw(15.0) }

        // THEN
        Assertions.assertThrows(RuntimeException::class.java, executable)
    }

    @Test
    fun `cash transfer should have positive amount`() {
        // GIVEN
        val bank = Bank()

        // WHEN
        val executable = { bank.transfer(Account("FR7630001007941234567890185"), Account("FR7630004000031234567890143"), -6.0) }

        // THEN
        Assertions.assertThrows(RuntimeException::class.java, executable)
    }

    @Test
    fun `account with invalid IBAN should not be accepted`() {
        // WHEN
        val executable: () -> Unit = { Account("iban1", 0.0) }

        Assertions.assertThrows(RuntimeException::class.java, executable)
    }

}
