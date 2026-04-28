package org.example.views.ledger;

import org.example.models.Ledger;
import org.example.models.TransactionsRepository;
import org.example.utils.MesageColor;
import org.example.utils.UI;


public class AllTransactionsView {
    private static int TransactionsPage = 0;

    public static void view() {
        Ledger ledger = new Ledger(new TransactionsRepository());


        IO.println("Viewing Ledger");

        boolean differentColor = false;
        String userInput;

        while (TransactionsPage < ledger.viewTransactions().size()) {

            String rowColor = differentColor ? MesageColor.WHITE_BG : MesageColor.BLACK_BG;

            IO.println(rowColor + ledger.viewTransactions().get(TransactionsPage).prettyString() + MesageColor.RESET);

            if (TransactionsPage % 5 == 0 && TransactionsPage != 0) {

                IO.print("Enter to continue / or exit to quit ....");

                userInput = UI.getUserInput();

                if (userInput.equalsIgnoreCase("exit")) {
                    TransactionsPage = ledger.viewTransactions().size();
                    continue;
                }
            }


            differentColor = !differentColor;
            TransactionsPage++;
        }
    }
}
