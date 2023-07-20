package org.acensi.domain.unit;

import org.acensi.domain.Account;
import org.acensi.domain.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class AccountTest {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    public void newAccount_ShouldHaveZeroBalance() {
        int balance = account.getBalance();
        Assertions.assertEquals(0, balance);
    }

    @Test
    public void deposit_ShouldIncreaseBalance() {
        account.deposit(100);
        int balance = account.getBalance();
        Assertions.assertEquals(100, balance);
    }

    @Test
    public void deposit_ShouldThrowException_WhenAmountIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    public void withdraw_ShouldDecreaseBalance() {
        account.deposit(100);
        account.withdraw(50);
        int balance = account.getBalance();
        Assertions.assertEquals(50, balance);
    }

    @Test
    public void withdraw_ShouldThrowException_WhenAmountIsNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
    }

    @Test
    public void withdraw_ShouldThrowException_WhenInsufficientFunds() {
        account.deposit(100);
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));
    }


    @Test
    public void getTransactions_ShouldReturnListOfTransactions() {
        account.deposit(100);
        account.withdraw(50);
        List<Transaction> transactions = account.getTransactions();
        Assertions.assertEquals(2, transactions.size());
    }
}
