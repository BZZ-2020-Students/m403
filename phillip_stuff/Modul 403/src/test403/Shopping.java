package test403;

import java.util.Scanner;

/**
 * Dieses Programm hilft dem Benutzer, sein Budget zu verwalten.
 *
 * @author Marcel Suter
 * @version 1.0
 * @date 2018-11-23
 */
public class Shopping {

    // declare attributes
    static Scanner scanner;

    /**
     * constructor: initialize attributes
     */
    public Shopping () {
        scanner = new Scanner (System.in);
    }

    /**
     * starts the execution
     *
     * @param args command line arguments
     */
    public static void main (String[] args) {
        Shopping program = new Shopping ();
        program.run ();
        scanner.close ();
    }

    /**
     * description
     */
    private void run () {
        double price = 1;
        double total = 0;

        System.out.print ("Budget\t> ");
        while (!scanner.hasNextDouble ()) {
            System.out.println ("Budget muss eine Zahl sein");
            System.out.print ("Budget\t> ");
            scanner.nextLine ();
        }
        double budget = scanner.nextDouble ();

        if (budget <= 0) {
            System.out.println ("Du hast kein Geld");
        }
        else {
            while (budget > total && price > 0) {
                System.out.print ("Kosten (0=Ende)\t> ");
                while (!scanner.hasNextDouble ()) {
                    System.out.println ("Kosten muss eine Zahl sein");
                    System.out.print ("Kosten (0=Ende)\t> ");
                    scanner.nextLine ();
                }
                price = scanner.nextDouble ();
                total = total + price;
                System.out.format ("Total\t: %.2f\n", total);
            }
            if (price > 0) {
                System.out.println ("Budget aufgebraucht");
            }
            else {
                System.out.println ("Einkauf beendet");
            }
            System.out.format ("Rest\t\t: %.2f", budget - total);
        }


    }
}