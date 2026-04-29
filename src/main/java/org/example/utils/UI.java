package org.example.utils;

import org.example.models.Transaction;

import java.util.List;
import java.util.Scanner;

public class UI {

    static private final Scanner scanner = new Scanner(System.in);

    public static String getUserInput() {
        return scanner.nextLine().trim();
    }

    public static void displayFormattedTable(List<Transaction> transactions) {
        int TransactionsPage = 0;
        boolean changeColor = true;
        while (TransactionsPage < transactions.size()) {

            Transaction transaction = transactions.get(TransactionsPage);

            String backgroundColor = changeColor ? MessageColor.BLACK_BG : MessageColor.WHITE_BG;

            if (TransactionsPage != 0 && TransactionsPage % 10 == 0) {
                IO.println("Press Enter To Continue...");
                UI.getUserInput();

            }

            IO.println(backgroundColor + transaction.prettyString() + MessageColor.RESET);

            TransactionsPage++;
            changeColor = !changeColor;
        }
    }

}
