package org.example;

import org.example.enums.PaymentType;
import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.models.TransactionsRepository;
import org.example.views.HomeView;

import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LedgerApplication {
    static void main() {
        Ledger ledger = new Ledger(new TransactionsRepository());

        for (Transaction transaction : ledger.previousMonth()){
            IO.println(transaction);
        }

        HomeView.view();
    }
}
