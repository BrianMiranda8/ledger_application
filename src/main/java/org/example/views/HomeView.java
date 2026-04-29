package org.example.views;

import org.example.models.Ledger;
import org.example.models.TransactionsRepository;
import org.example.utils.MessageColor;
import org.example.utils.UI;
import org.example.views.home.DepositView;
import org.example.views.home.PaymentView;
import org.example.views.ledger.LegderView;

public class HomeView {
    static boolean isLooping = true;
    public static void view(){
        Ledger ledger = new Ledger(new TransactionsRepository());

        while (isLooping) {
            IO.println(MessageColor.RED + "Ledger Application" + MessageColor.RESET);
            TransactionsRepository transactionsRepository = new TransactionsRepository();
            IO.println("D) Add Deposit \n" +
                    "P) Make Payment \n" +
                    "L) View Ledger \n" +
                    "X) Exit");
            IO.print("Make Selection: ");
            String userInput = UI.getUserInput().toLowerCase();

            switch (userInput){
                case "d" -> DepositView.view(ledger);
                case "p" -> PaymentView.view(ledger);
                case "l" -> LegderView.view(ledger);
                case "x"-> exitProgram();
            }
        }

//        switch (userInput)

    }

    private static void exitProgram() {
        isLooping = false;
    }


}
