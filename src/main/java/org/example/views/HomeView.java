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
            IO.println(MessageColor.PURPLE);

            System.out.println("  _               _      ");
            System.out.println(" | |             | |                     ");
            System.out.println(" | |     ___   __| | __ _  ___ _ __     ");
            System.out.println(" | |    / _ \\ / _` |/ _` |/ _ \\ '__|   ");
            System.out.println(" | |___|  __/| (_| | (_| |  __/ |     ");
            System.out.println(" |______\\___| \\__,_|\\__, |\\___|_|     ");
            System.out.println("                     __/ |     ");
            System.out.println("                    |___/      ");

            IO.println(MessageColor.RESET);
            IO.println(MessageColor.PURPLE + "[1] Add Deposit" + MessageColor.RESET);
            IO.println(MessageColor.GREEN + "[2] Make Payment" + MessageColor.RESET);
            IO.println(MessageColor.BLUE + "[3] View Ledger" + MessageColor.RESET);
            IO.println(MessageColor.RED + "[0] Exit" + MessageColor.RESET);
            IO.print("Make Selection: ");

            String userInput = UI.getUserInput().toLowerCase();
            IO.println();
            switch (userInput){
                case "1" -> DepositView.view(ledger);
                case "2" -> PaymentView.view(ledger);
                case "3" -> LegderView.view(ledger);
                case "0"-> exitProgram();
            }
        }

//        switch (userInput)

    }

    private static void exitProgram() {
        isLooping = false;
    }


}
