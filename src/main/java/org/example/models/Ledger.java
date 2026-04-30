package org.example.models;

import org.example.enums.PaymentType;

import java.sql.Array;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ledger {
    // this would have an interface but for today ill use a direct class assignment
    TransactionsRepository repository;

    public Ledger(TransactionsRepository repository) {

        this.repository = repository;
    }

    public List<Transaction> monthToDate() {
        // month to date transactions

        LocalDate today = LocalDate.now();
        LocalDate firstOfMonth = LocalDate.now().withDayOfMonth(1);

       return    searchByDate(firstOfMonth, today);

    }

    public List<Transaction> previousMonth() {
        LocalDate startOfMonth = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate endOfMonth = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        return   searchByDate(startOfMonth, endOfMonth);


    }

    public List<Transaction> yearToDate() {
        LocalDate startDate = LocalDate.now().with(TemporalAdjusters.firstDayOfYear());
        LocalDate endDate = LocalDate.now();

        return searchByDate(startDate, endDate);
    }

    public List<Transaction> previousYear() {
        LocalDate startDate = LocalDate.now().minusYears(1).with(TemporalAdjusters.firstDayOfYear());
        LocalDate endDate = LocalDate.now().minusYears(1).with(TemporalAdjusters.lastDayOfYear());

        return  searchByDate(startDate, endDate);

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
    public List<Transaction> searchByDate(LocalDate startDate, LocalDate endDate) {


        ArrayList<Transaction> mtdTransactions = new ArrayList<>();


        for (Transaction transaction : this.repository.viewTransactions()) {
            // this is so we get today and the first of the month
            // as long as the date is NOT before the first of the month
            // AND the date is not after today
            if (!transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate)) {
                mtdTransactions.add(transaction);
            }
        }

        return mtdTransactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .toList();
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
                } else {
                    transaction.setAmount(transaction.getAmount());
                }
            }
        }

        repository.addTransaction(transaction);

    }

    public List<Transaction> viewTransactions() {

        // the stream creates a funnel for your items in a list
        Stream<Transaction> stream = repository.viewTransactions().stream();

        // then they are passed into an intermediate operation -> meaning some action is performed on the items
        // the sorted method can take a comparator which is factory that asks what are we comparing
        // im comparing the transactions on their date i then flip the sort to be from highest to lowest
        Stream<Transaction > sorted = stream.sorted(Comparator.comparing(Transaction::getDate).reversed());

        return   sorted.collect(Collectors.toList());
    }


    // todo: not working shows all payments
    public List<Transaction> viewDeposits(){
        return   this.viewTransactions().stream()
                .filter((t) -> t.getAmount() >= 0)
                .toList();
    }

    public List<Transaction> viewPayments(){
        return  this.viewTransactions().stream()
                .filter((t)-> t.getAmount() < 0)
                .toList();
    }


}
