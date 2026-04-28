package org.example.models;

import org.example.enums.PaymentType;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
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

        for (Transaction transaction : transactions){
            // this is so we get today and the first of the month
            // as long as the date is NOT before the first of the month
            // AND the date is not after today
            if(!transaction.getDate().isBefore(firstOfMonth) && !transaction.getDate().isAfter(today)){
                mtdTransactions.add(transaction);
            }
        }

        return mtdTransactions;
    }

    public ArrayList<Transaction> previousMonth(){
        ArrayList<Transaction> pmTransactions = new ArrayList<>();
        LocalDate startOfMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        // get
        LocalDate endOfMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());

        for (Transaction transaction : transactions){
            if(!transaction.getDate().isBefore(startOfMonth) && !transaction.getDate().isAfter(endOfMonth)){
                pmTransactions.add(transaction);
            }
        }

        return pmTransactions;
    }


    public void AddTransaction(PaymentType paymentType, Transaction transaction) throws Exception {

        switch (paymentType){
            case DEPOSIT -> {
                if(transaction.getAmount() < 0){
                    throw new Exception("Invalid amount for a deposit");
                }
            }
            case PAYMENT -> {
                if (transaction.getAmount() < 0){
                    transaction.setAmount(Math.abs(transaction.getAmount()));
                }
            }
        }

        repository.addTransaction(transaction);

    }

}
