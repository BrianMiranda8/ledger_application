package org.example.views.reports;

import org.example.models.Ledger;
import org.example.models.Transaction;
import org.example.models.TransactionSearch;
import org.example.utils.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * this whole class is the most nasty thing i have ever made
 */
public class CustomSearchView {

    public static void view(Ledger ledger) {
        boolean isLooping = true;

        while (isLooping) {

            TransactionSearch transactionSearch = new TransactionSearch();

            IO.println("Press Enter to skip: ");
            IO.print("Enter Start Date (yyyy-mm-dd):  ");
            String startDate = UI.getUserInput();
            if (startDate.equalsIgnoreCase("exit")){
                return;
            }
            IO.print("Enter End Date  (yyyy-mm-dd):   ");
            String endDate = UI.getUserInput();
            if (endDate.equalsIgnoreCase("exit")){
                return;
            }
            IO.print("Enter Description:  ");
            String description = UI.getUserInput();
            if (description.equalsIgnoreCase("exit")){
                return;
            }
            IO.print("Enter Vendor:  ");
            String vendor = UI.getUserInput();
            if (vendor.equalsIgnoreCase("exit")){
                return;
            }
            IO.print("Enter Amount:  ");
            String amount = UI.getUserInput();
            if (amount.equalsIgnoreCase("exit")){
                return;
            }

            try{

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            if (!startDate.isEmpty()) {
                LocalDate parseStartDate = LocalDate.parse(startDate, formatter);
                transactionSearch.setStartDate(parseStartDate);
            }
            if (!endDate.isEmpty()){
                LocalDate parseEndDate = LocalDate.parse(endDate, formatter);
                transactionSearch.setEndDate(parseEndDate);
            }
            if (!description.isEmpty()){
                transactionSearch.setDescription(description);
            }
            if(!vendor.isEmpty()){
                transactionSearch.setVendor(vendor);
            }
            if (!amount.isEmpty()){

                transactionSearch.setAmount(Double.parseDouble(amount));
            }

            ArrayList<Transaction> transactions = (ArrayList<Transaction>) transactionSearch.search(ledger);

            UI.displayFormattedTable(transactions);

            }catch (Exception e){
                IO.println("Try Again invalid input");
            }

        }
    }


}
