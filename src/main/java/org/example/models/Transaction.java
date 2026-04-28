package org.example.models;

import org.example.enums.PaymentType;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;


    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Transaction(String line){
        String[] transactions = line.split("\\|");
        this.date = LocalDate.parse(transactions[0]);
        this.time = LocalTime.parse(transactions[1]);
        this.description = transactions[2];
        this.vendor = transactions[3];
        this.amount = Double.parseDouble(transactions[4]);
    }

    public PaymentType getPaymentType(){
        return  this.amount >= 0 ? PaymentType.DEPOSIT : PaymentType.PAYMENT;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%s|%s|%s|%s|%.2f", this.date.format(dateFormat), this.time.format(timeFormatter), this.description,this.vendor,this.amount);
    }

    public String prettyString(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss a");
        return String.format("%-20s %-20s %-20s %-20s %-15.2f", this.date.format(dateFormat), this.time.format(timeFormatter), this.description,this.vendor,this.amount);
    }
}
