package com.domain.currencyexchange.main;

import com.domain.currencyexchange.models.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option = 10, base, target;

        ArrayList<Operation> operations = new ArrayList<>();
        Scanner keyboard = new Scanner(System.in);
        Apiconsulter api = new Apiconsulter();

        while (option != 0) {

            System.out.println("\n****************************** Welcome! **************************************");
            System.out.println("                  Select an option and start operating");
            System.out.println("******************************************************************************");
            System.out.println("-------------------- First select your base currency -------------------------");
            System.out.println("(1) ARS (Argentine Peso)   (2) BRL (Brazilian Real)  (3) CAD (Canadian Dollar)");
            System.out.println("(4) COP (Colombian Peso)   (5) CLP (Chilean Peso)    (6) EUR (EURO)");
            System.out.println("(7) GBP (Pound Sterling)   (8) JPY (Japanese Yen)    (9) USD (US Dollar)");
            System.out.println("                           (0) CANCEL");
            System.out.println("------------------------------------------------------------------------------");

            option = keyboard.nextInt();

            if (option == 0) {
                System.out.println("\n--------------------- The program ended successfully -------------------------");
                break;
            } else {
                base = option;
            }

            System.out.println("\n--------------------- Now select your target currency ------------------------");
            System.out.println("(1) ARS (Argentine Peso)   (2) BRL (Brazilian Real)  (3) CAD (Canadian Dollar)");
            System.out.println("(4) COP (Colombian Peso)   (5) CLP (Chilean Peso)    (6) EUR (EURO)");
            System.out.println("(7) GBP (Pound Sterling)   (8) JPY (Japanese Yen)    (9) USD (US Dollar)");
            System.out.println("                           (0) CANCEL                                         ");
            System.out.println("------------------------------------------------------------------------------");

            option = keyboard.nextInt();

            if (option == 0) {
                System.out.println("\n--------------------- The program ended successfully -------------------------");
                break;
            } else {
                target = option;
            }

            System.out.println("\n--------------------- Now enter the amount to convert ------------------------");

            double amount = keyboard.nextDouble();
            Pair result = api.consult(base, target, amount);
            operations.add(new Operation(result, new Date()));

            System.out.println("\n------------------------------------------------------------------------------");
            System.out.println("The conversion rate of the pair your consulting is: " + result.base_code() + "/" + result.target_code() + " = $" + result.conversion_rate());
            System.out.println("                    " + result.base_code() + "= $" + amount + " / " + result.target_code() + "= $" + result.conversion_result());
            System.out.println("------------------------------------------------------------------------------");

        }


        System.out.println("\n--------------------------------- History ------------------------------------");
        for (Operation operation : operations) {
            System.out.println(operation);
        }
        System.out.println("------------------------------------------------------------------------------");

    }
}