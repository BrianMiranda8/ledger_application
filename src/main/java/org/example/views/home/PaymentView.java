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

//        Ledger ledger = new Ledger(new TransactionsRepository());

        while(isLooping){
            try{
                IO.println(MessageColor.GREEN);
                IO.println("Add New Payment");
                IO.println("Enter 'exit' to quit");
                IO.println("---------------------");


                IO.println("Enter Date Format yyyy-mm-dd");
                IO.print("Enter Date : ");
                String userInputDate = UI.getUserInput();
                checkExitCondition(userInputDate);

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate userDate = LocalDate.parse(userInputDate,dateTimeFormatter);
                LocalTime time = LocalTime.now();
                IO.println("---------------------");

                IO.print("Enter Description: ");
                String userDescription = UI.getUserInput();
                checkExitCondition(userDescription);
                IO.println("---------------------");

                IO.print("Enter Vendor: ");
                String userVendor = UI.getUserInput();
                checkExitCondition(userVendor);

                IO.println("---------------------");
                IO.print("Enter Amount: ");
                String userAmount = UI.getUserInput();
                checkExitCondition(userAmount);

                ledger.addTransaction(PaymentType.PAYMENT, new Transaction(userDate,time,userDescription,userVendor,Double.parseDouble(userAmount)));
                IO.println(MessageColor.RESET);
                IO.println(MessageColor.BLACK_BG + "Deposit Entered" + MessageColor.RESET);

                IO.println("Enter To Enter New Deposit or exit to quit");
                String exitInput = UI.getUserInput();
                checkExitCondition(exitInput);

            } catch (Exception e) {
                IO.println(MessageColor.BLACK_BG+ MessageColor.RED +"Error your deposit was not added"+ MessageColor.RESET);
            }
        }

    }

    private static void checkExitCondition(String exitCondition){
        if (exitCondition.equalsIgnoreCase("exit")){
            isLooping = false;

        }
    }

}
