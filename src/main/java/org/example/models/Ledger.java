package org.example.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ledger {
    // this would have an interface but for today ill use a direct class assignment
    TransactionsRepository repository;
    ArrayList<Transaction> transactions;

    public Ledger(TransactionsRepository repository) {

        this.repository = repository;
        this.transactions = (ArrayList<Transaction>) repository.viewTransactions();
    }


    public ArrayList<Transaction> monthToDate(){
        // month to date transactions
        ArrayList<Transaction> mtdTransactions = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate firstOfMonth = LocalDate.now().withDayOfMonth(1);

//        for (Transaction transaction : transactions){
//            if (transaction.getDate().isAfter(firstOfMonth) && transaction.getDate().isBefore(today) || transaction.getDate().isEqual(today)){
//
//            }
//        }

        return mtdTransactions;
    }

}
