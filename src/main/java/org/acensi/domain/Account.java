package org.acensi.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Account {
    private int balance;
    private List<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    /**
     * It saves the amount to deposit and create a transaction for it.
     *
     * @param amount : The amount to deposit
     */
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        Transaction deposit = Transaction.builder()
                .amount(amount)
                .type(TransactionType.DEPOSIT)
                .date(LocalDate.now())
                .build();
        transactions.add(deposit);
        balance += amount;
    }

    /**
     * It saves the amount to withdraw and create a transaction for it.
     *
     * @param amount : The amount to withdraw
     */
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (!hasSufficientFunds(amount)) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        Transaction withdrawal = Transaction.builder()
                .amount(-amount)
                .type(TransactionType.WITHDRAWAL)
                .date(LocalDate.now())
                .build();
        transactions.add(withdrawal);
        balance -= amount;
    }

    /**
     *
     * @param amount
     * @return True : If there is sufficient funds in the account | false : If not
     */
    private boolean hasSufficientFunds(int amount) {
        return balance >= amount;
    }

}