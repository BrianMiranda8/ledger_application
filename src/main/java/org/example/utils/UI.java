package org.example.utils;

import java.util.Scanner;

public class UI {

        static private final Scanner scanner = new Scanner(System.in);

        public static String getUserInput(){
            return scanner.nextLine().trim();
        }

}
