package org.acensi.domain;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class Statement {
    private static final String HEADER = "DATE | AMOUNT | BALANCE";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private List<Transaction> transactions;

    public Statement(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Prints all transactions on the console
     */
    public void print() {
        System.out.println(HEADER);
        int balance = 0;

        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            System.out.printf("%s | %d | %d%n",
                    transaction.getDate().format(DATE_FORMATTER),
                    transaction.getAmount(),
                    balance);
        }
    }
}