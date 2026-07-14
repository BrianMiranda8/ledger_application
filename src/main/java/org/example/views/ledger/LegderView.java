package org.example.views.ledger;

import org.example.models.Ledger;
import org.example.utils.MessageColor;
import org.example.utils.UI;
import org.example.views.reports.ReportsView;

public class LegderView {

    public static void view(Ledger ledger) {

         boolean isLooping = true;

        while (isLooping) {
            IO.println(MessageColor.BLUE);
            IO.println("Ledger View");
            IO.println(
                    "[1] View All Transactions \n" +
                    "[2] View Deposits \n" +
                    "[3] View Payments \n" +
                    "[4] Reports \n" +
                    "[0] Home" + MessageColor.RESET);
            IO.print("Enter Selection: ");
            String userInput = UI.getUserInput().toLowerCase();
            switch (userInput) {
                case "1":
                    TransactionsView.viewAll(ledger);
                    break;
                case "2":
                    TransactionsView.viewDeposits(ledger);
                    break;
                case "3":
                    TransactionsView.viewPayments(ledger);
                    break;
                case "4":
                    ReportsView.view(ledger);
                    break;
                default:
                    isLooping = false;
            }
        }
    }
}
