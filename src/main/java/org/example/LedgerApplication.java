package org.example;

import org.example.enums.PaymentType;
import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.models.TransactionsRepository;
import org.example.views.HomeView;

import java.time.LocalDate;
import java.time.LocalTime;


public class LedgerApplication {
    static void main() {

        HomeView.view();
    }
}
