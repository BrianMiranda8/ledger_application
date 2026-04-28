package org.example.models;

import org.example.enums.PaymentType;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

public class Ledger {
    // this would have an interface but for today ill use a direct class assignment
    TransactionsRepository repository;

    public Ledger(TransactionsRepository repository) {

        this.repository = repository;
    }

    public ArrayList<Transaction> monthToDate() {
        // month to date transactions
        ArrayList<Transaction> mtdTransactions;
        LocalDate today = LocalDate.now();
        LocalDate firstOfMonth = LocalDate.now().withDayOfMonth(1);

        mtdTransactions = searchByDate(firstOfMonth, today);

        return mtdTransactions;
    }

    public ArrayList<Transaction> previousMonth() {
        ArrayList<Transaction> pmTransactions;
        LocalDate startOfMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);

        LocalDate endOfMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        pmTransactions = searchByDate(startOfMonth, endOfMonth);

        return pmTransactions;
    }

    public ArrayList<Transaction> yearToDate() {
        LocalDate startDate = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
        LocalDate endDate = LocalDate.now();

        return searchByDate(startDate, endDate);
    }

    public ArrayList<Transaction> previousYear() {
        LocalDate startDate = LocalDate.now().minusYears(1).with(TemporalAdjusters.firstDayOfYear());
        LocalDate endDate = LocalDate.now().minusYears(1).with(TemporalAdjusters.lastDayOfYear());

        return searchByDate(startDate, endDate);

    }

    public ArrayList<Transaction> byVendor(String search) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        for (Transaction transaction : this.repository.viewTransactions()) {
            if (transaction.getVendor().toLowerCase().contains(search.toLowerCase())) {
                transactions.add(transaction);
            }
        }

        return transactions;
    }

    /**
     * Format must be yyyy-mm-dd
     *
     * @param startDate
     * @param endDate
     */
    public ArrayList<Transaction> searchByDate(LocalDate startDate, LocalDate endDate) {


        ArrayList<Transaction> mtdTransactions = new ArrayList<>();


        for (Transaction transaction : this.repository.viewTransactions()) {
            // this is so we get today and the first of the month
            // as long as the date is NOT before the first of the month
            // AND the date is not after today
            if (!transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate)) {
                mtdTransactions.add(transaction);
            }
        }

        return mtdTransactions;
    }

    public void addTransaction(PaymentType paymentType, Transaction transaction) throws Exception {

        switch (paymentType) {
            case DEPOSIT -> {
                if (transaction.getAmount() < 0) {
                    throw new Exception("Invalid amount for a deposit");
                }
            }
            case PAYMENT -> {
                if (transaction.getAmount() > 0) {
                    transaction.setAmount(-transaction.getAmount());
                }else{
                    transaction.setAmount(transaction.getAmount());
                }
            }
        }

        repository.addTransaction(transaction);

    }

    public ArrayList<Transaction> viewTransactions(){
        return (ArrayList<Transaction>)this.repository.viewTransactions();
    }


}
