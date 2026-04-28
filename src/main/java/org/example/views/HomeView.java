package org.example.views;

import org.example.models.Transaction;
import org.example.models.TransactionsRepository;
import org.example.utils.UI;

public class HomeView {
    static boolean isLooping = true;
    public static void view(){


        while (isLooping) {
            IO.println("Ledger Application");
            IO.println("Options ....");
            TransactionsRepository transactionsRepository = new TransactionsRepository();
            IO.println("D) Add Deposit \n" +
                    "P) Make Payment \n" +
                    "L) View Ledger \n" +
                    "X) Exit");
            IO.print("Make Selection: ");
            String userInput = UI.getUserInput().toLowerCase();

            switch (userInput){
                case "d" -> DepositView.view();
                case "p" -> PaymentView.view();
                case "l" -> LegderView.view();
            }
        }

//        switch (userInput)

    }

}
