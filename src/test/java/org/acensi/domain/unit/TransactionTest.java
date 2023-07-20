package org.acensi.domain.unit;

import org.acensi.domain.Transaction;
import org.acensi.domain.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TransactionTest {
    @Test
    public void newTransaction_ShouldHaveCorrectValues() {
        int amount = 100;
        TransactionType type = TransactionType.DEPOSIT;
        LocalDate date = LocalDate.now();

        Transaction transaction = new Transaction(amount, type, date);

        Assertions.assertEquals(amount, transaction.getAmount());
        Assertions.assertEquals(type, transaction.getType());
        Assertions.assertEquals(LocalDate.now(), transaction.getDate());
    }
}
