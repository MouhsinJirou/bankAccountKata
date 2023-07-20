package org.acensi.domain.integration;

import org.acensi.domain.Account;
import org.acensi.domain.Statement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

public class BankingIntegrationTest {
    private Account account;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        account = new Account();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void bankingIntegrationTest_ShouldPrintCorrectStatement() {
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(800);

        Statement statement = new Statement(account.getTransactions());
        statement.print();

        String expectedOutput = "DATE | AMOUNT | BALANCE" +System.lineSeparator()+
                LocalDate.now()+ " | 1000 | 1000" +System.lineSeparator()+
                LocalDate.now()+ " | -500 | 500" +System.lineSeparator()+
                LocalDate.now()+ " | 800 | 1300" + System.lineSeparator();
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
}
