package org.acensi.domain.unit;

import org.acensi.domain.Statement;
import org.acensi.domain.Transaction;
import org.acensi.domain.TransactionType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

public class StatementTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void print_ShouldPrintStatement() {
        final List<Transaction> transactions = List.of(Transaction.builder()
                        .amount(1000)
                        .type(TransactionType.DEPOSIT)
                        .date(LocalDate.of(2023, 1, 3)).build(),
                Transaction.builder()
                        .amount(-500)
                        .type(TransactionType.WITHDRAWAL)
                        .date(LocalDate.of(2023, 1, 2)).build(),
                Transaction.builder()
                        .amount(800)
                        .type(TransactionType.DEPOSIT)
                        .date(LocalDate.of(2023, 1, 1)).build()
        );

        Statement statement = new Statement(transactions);

        String expectedOutput = "DATE | AMOUNT | BALANCE" +System.lineSeparator()+
                "2023-01-03 | 1000 | 1000" +System.lineSeparator()+
                "2023-01-02 | -500 | 500" +System.lineSeparator()+
                "2023-01-01 | 800 | 1300" + System.lineSeparator();

        statement.print();
        String printedOutput = outputStream.toString();

        Assertions.assertEquals(expectedOutput, printedOutput);
    }
}

