package org.acensi;

import org.acensi.domain.Account;
import org.acensi.domain.Statement;
import org.acensi.domain.Transaction;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

        Account account = new Account();
        account.deposit(100);
        account.withdraw(50);
        account.deposit(200);

        List<Transaction> transactions = account.getTransactions();
        Statement statement = new Statement(transactions);
        statement.print();
    }
}
