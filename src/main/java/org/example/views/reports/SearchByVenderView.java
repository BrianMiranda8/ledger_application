package org.example.views.reports;

import org.example.models.Ledger;
import org.example.utils.UI;

public class SearchByVenderView {
    public static void view(Ledger ledger) {
        boolean isLooping = true;

        while (isLooping){
            IO.print("       Enter Vendor: ");
            String userInput = UI.getUserInput();
            if (userInput.contains("exit")){
                isLooping = false;
            }
            ledger.byVendor(userInput).forEach(t -> IO.println(t.prettyString()));
        }




    }
}
