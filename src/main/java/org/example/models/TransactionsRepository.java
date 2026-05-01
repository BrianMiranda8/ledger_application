package org.example.models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionsRepository {
    private final static String FILENAME = "data/transactions.csv";

    private final List<Transaction> transactions = new ArrayList<>();

    public TransactionsRepository() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {

            String header = bufferedReader.readLine();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                transactions.add(new Transaction(line));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void addTransaction(Transaction transaction) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILENAME, true))) {

            bufferedWriter.write("\n" + transaction.toString());
            this.transactions.add(transaction);

        } catch (Exception e) {
            IO.println("Error occurred while saving transaction" + e);
        }
    }

    public List<Transaction> viewTransactions() {
        return transactions;
    }
}
