package org.example.views.home;

import org.example.enums.PaymentType;
import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.utils.MessageColor;
import org.example.utils.UI;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DepositView    {
    static boolean isLooping = true;
    public static void view(Ledger ledger) {

        while(isLooping){
            try{
                IO.println(MessageColor.PURPLE);
                IO.println("Add new Deposit");

                IO.println("Enter 'Exit' to quit");
                IO.println("Enter Date Format yyyy-mm-dd");
                IO.print("Enter Date : ");
                String userDateInput = UI.getUserInput();
                checkExitCondition(userDateInput);


                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate userDate = LocalDate.parse(userDateInput,dateFormatter);
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

                ledger.addTransaction(PaymentType.DEPOSIT ,new Transaction(userDate,time,userDescription,userVendor,Double.parseDouble(userAmount)));
                IO.println(MessageColor.RESET);
                IO.println(MessageColor.BLACK_BG + "Deposit Entered" + MessageColor.RESET);


                IO.println("Press Enter To Enter New Deposit or exit to quit");
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
