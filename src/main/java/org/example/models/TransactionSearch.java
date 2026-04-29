package org.example.models;

import java.time.LocalDate;

public class TransactionSearch {
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private String vendor;
    private String amount;

    public TransactionSearch(LocalDate startDate, LocalDate endDate, String description, String vendor, String amount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
