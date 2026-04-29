package org.example.views.home;

import org.example.enums.PaymentType;
import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.utils.MessageColor;
import org.example.utils.UI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PaymentView {
    static boolean isLooping = true;

    public static void view(Ledger ledger) {
        IO.println("Adding new Payment");

//        Ledger ledger = new Ledger(new TransactionsRepository());

        while(isLooping){
            try{
                IO.println("Enter Date Format yyyy-mm-dd");
                IO.print("Enter Date : ");
                String userInputDate = UI.getUserInput();
                exitProgram(userInputDate);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate userDate = LocalDate.parse(userInputDate,dateTimeFormatter);
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

                IO.println(MessageColor.BLACK_BG + "Deposit Entered" + MessageColor.RESET);
            } catch (Exception e) {
                IO.println(MessageColor.BLACK_BG+ MessageColor.RED +"Error your deposit was not added"+ MessageColor.RESET);
            }
        }

    }

    private static void exitProgram(String exitCondition){
        if (exitCondition.equalsIgnoreCase("exit")){
            isLooping = false;

        }
    }

}
