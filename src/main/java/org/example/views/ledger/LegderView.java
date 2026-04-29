package org.example.views.ledger;

import org.example.models.Ledger;
import org.example.utils.MessageColor;
import org.example.utils.UI;
import org.example.views.reports.ReportsView;

public class LegderView {

    public static void view(Ledger ledger) {

         boolean isLooping = true;

        while (isLooping) {
            IO.println("Ledger View");
            IO.println(MessageColor.BLUE +
                    "     A) View All Transactions \n" +
                    "     D) View Deposits \n" +
                    "     P) View Payments \n" +
                    "     R) Reports \n" +
                    "     H) Home" + MessageColor.RESET);
            IO.print("Enter Selection: ");
            String userInput = UI.getUserInput().toLowerCase();
            switch (userInput) {
                case "a":
                    TransactionsView.viewAll(ledger);
                    break;
                case "d":
                    TransactionsView.viewDeposits(ledger);
                    break;
                case "p":
                    TransactionsView.viewPayments(ledger);
                    break;
                case "r":
                    ReportsView.view(ledger);
                    break;
                default:
                    isLooping = false;
            }
        }
    }
}
