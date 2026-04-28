package org.example.views.home;

import org.example.enums.PaymentType;
import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.models.TransactionsRepository;
import org.example.utils.MesageColor;
import org.example.utils.UI;

import java.time.LocalDate;
import java.time.LocalTime;

public class PaymentView {
    static boolean isLooping = true;

    public static void view() {
        IO.println("Adding new Payment");

        Ledger ledger = new Ledger(new TransactionsRepository());

        while(isLooping){
            try{
                IO.println("Enter Date Format yyyy-mm-dd");
                IO.print("Enter Date : ");
                LocalDate userDate = LocalDate.parse(UI.getUserInput());
                LocalTime time = LocalTime.now();
                IO.println("");
                IO.print("Enter Description: ");
                String userDescription = UI.getUserInput();
                exitProgram(userDescription);
                IO.println("");
                IO.print("Enter Vendor: ");
                String userVendor = UI.getUserInput();
                exitProgram(userVendor);
                IO.println("");
                IO.print("Enter Amount: ");
                String userAmount = UI.getUserInput();
                exitProgram(userAmount);
                ledger.addTransaction(PaymentType.PAYMENT, new Transaction(userDate,time,userDescription,userVendor,Double.parseDouble(userAmount)));

                IO.println(MesageColor.BLACK_BG + "Deposit Entered" + MesageColor.RESET);
            } catch (Exception e) {
                IO.println("Error your deposit was not added");
            }
        }

    }

    private static void exitProgram(String exitCondition){
        if (exitCondition.equalsIgnoreCase("exit")){
            isLooping = false;
        }
    }

}
