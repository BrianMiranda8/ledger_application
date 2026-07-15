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

    public static void view(Ledger ledger) {

//        Ledger ledger = new Ledger(new TransactionsRepository());
        boolean isLooping = true;
        while(isLooping){
            try{
                IO.println(MessageColor.GREEN);
                IO.println("Add New Payment");
                IO.println("Enter 'exit' to quit");
                IO.println("---------------------");


                IO.println("Enter Date Format yyyy-mm-dd");
                IO.print("Enter Date : ");
                String userInputDate = UI.getUserInput();

                if(userInputDate.equalsIgnoreCase("exit"))
                {
                    isLooping = false;
                    continue;
                }

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate userDate = LocalDate.parse(userInputDate,dateTimeFormatter);
                LocalTime time = LocalTime.now();

                IO.println("---------------------");

                IO.print("Enter Description: ");
                String userDescription = UI.getUserInput();

                if(userDescription.equalsIgnoreCase("exit"))
                {
                    isLooping = false;
                    continue;
                }

                IO.println("---------------------");

                IO.print("Enter Vendor: ");
                String userVendor = UI.getUserInput();
                if(userVendor.equalsIgnoreCase("exit"))
                {
                    isLooping = false;
                    continue;
                }


                IO.println("---------------------");
                IO.print("Enter Amount: ");
                String userAmount = UI.getUserInput();
                if(userAmount.equalsIgnoreCase("exit"))
                {
                    isLooping = false;
                    continue;
                }


                ledger.addTransaction(PaymentType.PAYMENT, new Transaction(userDate,time,userDescription,userVendor,Double.parseDouble(userAmount)));
                IO.println(MessageColor.RESET);
                IO.println(MessageColor.BLACK_BG + "Deposit Entered" + MessageColor.RESET);

                IO.println("Press Enter To Enter New Deposit or exit to quit");
                String exitInput = UI.getUserInput();
                if(exitInput.equalsIgnoreCase("exit"))
                {
                    isLooping = false;
                    continue;
                }


            } catch (Exception e) {
                IO.println(MessageColor.BLACK_BG+ MessageColor.RED +"Error your deposit was not added"+ MessageColor.RESET);
            }
        }

    }

}
