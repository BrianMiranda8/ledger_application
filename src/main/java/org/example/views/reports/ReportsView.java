package org.example.views.reports;

import org.example.models.Ledger;
import org.example.utils.MessageColor;
import org.example.utils.UI;

public class ReportsView {
    public static void view(Ledger ledger) {
        boolean isLooping = true;

        while (isLooping){
            IO.println(MessageColor.GREEN + "View Reports");
            IO.println(
                    "   1) Month To Date \n" +
                    "   2) Previous Month \n" +
                    "   3) Year To Date \n" +
                    "   4) Previous Year \n " +
                    "  5) Search By Vendor \n" +
                    "   6) Custom Search \n" +
                    "   0) Back" );
            IO.print("Enter Selection:  " + MessageColor.RESET);
          String userInput =   UI.getUserInput();
            switch (userInput){
                case "1"  -> {
                    UI.displayFormattedTable(ledger.monthToDate());
                }
                case "2" ->{
                    UI.displayFormattedTable(ledger.previousMonth());
                }
                case "3" -> {
                    UI.displayFormattedTable(ledger.yearToDate());
                }
                case "4" ->{
                    UI.displayFormattedTable(ledger.previousYear());
                }
                case "5" ->{
                    SearchByVenderView.view(ledger);
                }
                case "6"->{
                    CustomSearchView.view(ledger);
                }

                default ->  {
                    isLooping = false;
                }
            }
        }

    }
}
