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
    public static void view(Ledger ledger) {

        boolean isLooping = true;
        while(isLooping){
            try{
                IO.println(MessageColor.PURPLE);
                IO.println("Add new Deposit");

                IO.println("Enter 'Exit' to quit");
                IO.println("Enter Date Format yyyy-mm-dd");
                IO.print("Enter Date : ");
                String userDateInput = UI.getUserInput();

                if(userDateInput.equalsIgnoreCase("exit"))
                {
                    isLooping = false;
                    continue;
                }

                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate userDate = LocalDate.parse(userDateInput,dateFormatter);
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

                while (true)
                {
                    IO.print("Enter Amount: ");
                    String userAmount = UI.getUserInput();

                    try
                    {
                        if(userAmount.equalsIgnoreCase("exit"))
                        {
                            isLooping = false;
                            continue;
                        }

                        double userAmountInt = Double.parseDouble(userAmount);

                        if (userAmountInt < 0)
                        {
                            IO.println("Error, please enter a valid amount and try again");
                            continue;
                        }
                        break;
                    }

                    catch (Exception ex)
                    {
                        IO.println("Error, please enter a valid amount and try again");
                    }
                    ledger.addTransaction(PaymentType.DEPOSIT ,new Transaction(userDate,time,userDescription,userVendor,Double.parseDouble(userAmount)));


                }


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
