package org.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionSearch {
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String vendor;
    private Double amount;

    public TransactionSearch(LocalDate startDate, LocalDate endDate, String description, String vendor, double amount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public TransactionSearch(){}
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Copied from Imanuel
     * @param ledger
     * @return
     */
    public List<Transaction> search(Ledger ledger) {
        return ledger.viewTransactions()
                .stream()
                .filter(transaction -> vendor == null || transaction.getVendor().contains(vendor))
                .filter(transaction -> description == null || transaction.getDescription().contains(description))
                .filter(transaction -> amount == null || transaction.getAmount() == amount)
                .filter(transaction -> startDate == null || !transaction.getDate().isBefore(startDate))
                .filter(transaction -> endDate == null || !transaction.getDate().isAfter(endDate))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
