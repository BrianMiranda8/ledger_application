package org.example.views.ledger;

import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.utils.UI;

import java.util.List;


public class TransactionsView {
    private static final int TransactionsPage = 0;

    public static void viewAll(Ledger ledger) {
        List<Transaction> transactions = ledger.viewTransactions();
        UI.displayFormattedTable(transactions);
    }


    public static void viewDeposits(Ledger ledger) {
        UI.displayFormattedTable(ledger.viewDeposits());
    }

    public static void viewPayments(Ledger ledger) {
        UI.displayFormattedTable(ledger.viewPayments());
    }
}
