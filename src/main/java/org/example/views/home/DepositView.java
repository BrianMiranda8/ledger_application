package org.example.views.home;

import org.example.enums.PaymentType;
import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.models.TransactionsRepository;
import org.example.utils.MesageColor;
import org.example.utils.UI;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DepositView    {
    static boolean isLooping = true;
    public static void view(Ledger ledger) {
        IO.println("Adding new Deposit");


        while(isLooping){
            try{
                IO.println("Enter 'Exit' to quit");
                IO.println("Enter Date Format yyyy-mm-dd");
                IO.print("Enter Date : ");
                String userDateInput = UI.getUserInput();
                exitProgram(userDateInput);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate userDate = LocalDate.parse(userDateInput,dateFormatter);
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

                ledger.addTransaction(PaymentType.DEPOSIT ,new Transaction(userDate,time,userDescription,userVendor,Double.parseDouble(userAmount)));

                IO.println(MesageColor.BLACK_BG + "Deposit Entered" + MesageColor.RESET);
            } catch (Exception e) {
                IO.println(MesageColor.BLACK_BG+ MesageColor.RED +"Error your deposit was not added"+MesageColor.RESET);
            }
        }

    }
    private static void exitProgram(String exitCondition){
        if (exitCondition.equalsIgnoreCase("exit")){
            isLooping = false;
        }
    }

}
