package DistanceConverter;
import java.util.Scanner;

/**
 * convert different distance units
 *
 * @author Marcel Suter
 * @version 1.0
 * @since 2018-12-10
 */
public class DistanceConverter {

    // declare attributes
    static Scanner scanner;

    /**
     * constructor: initialize attributes
     */
    public DistanceConverter() {
        scanner = new Scanner(System.in);
    }

    /**
     * starts the execution
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        DistanceConverter program = new DistanceConverter ();
        program.run();
        scanner.close();
    }

    /**
     * runs the converter
     */
    private void run() {
        int unitFrom = -1;
        int unitTo = -1;
        double length = 0;

        while (length <= 0) {
            System.out.print("Länge >");
            while (!scanner.hasNextDouble ()) {
                System.out.println("Länge muss eine positive Zahl sein.");
                scanner.nextLine();
                System.out.print("Länge >");
            }
            length = scanner.nextDouble ();
            if (length <= 0) {
                System.out.println("Länge muss eine positive Zahl sein.");
                length = 0;
            }
        }

        System.out.println("Zulässige Einheiten für die Umrechnung:");
        System.out.println("1=Meter, 2=Meilen, 3=Seemeilen, 4=Yard, 5=Inches");
        while (unitFrom == -1) {
            System.out.print("Einheit von (1-5) >");
            while (!scanner.hasNextInt ()) {
                System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                scanner.nextLine();
                System.out.print("Einheit von (1-5) >");
            }
            unitFrom = scanner.nextInt ();
            if (unitFrom < 1 || unitFrom > 5) {
                unitFrom = -1;
                System.out.println ("Unbekannte Einheit. Bitte 1-5 eingeben.");
            }
        }

        while (unitTo == -1) {
            System.out.print("Einheit nach (1-5) >");
            while (!scanner.hasNextInt ()) {
                System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                scanner.nextLine();
                System.out.print("Einheit nach (1-5) >");
            }
            unitTo = scanner.nextInt ();
            if (unitTo < 1 || unitTo > 5) {
                unitTo = -1;
                System.out.println ("Unbekannte Einheit. Bitte 1-5 eingeben.");
            }
        }

        System.out.format("%f ", length);
        double result = length;
        if (unitFrom == 1) {
            System.out.print ("Meter");
        }
        else if (unitFrom == 2) {
            System.out.print ("Meilen");
            result = length * 1609.34;
        }
        else if (unitFrom == 3) {
            System.out.print ("Seemeilen");
            result = length * 1852.0;
        }
        else if (unitFrom == 4) {
            System.out.print ("Yards");
            result = length * 0.9144;
        }
        else if (unitFrom == 5) {
            System.out.print ("Inches");
            result = length * 0.0254;
        }

        System.out.print(" entspricht ");
        if (unitTo == 1) {
            System.out.format("%s %.3f", "Meter", result);
        }
        if (unitTo == 2) {
            result = result / 1609.34;
            System.out.format("%s %.3f", "Meilen", result);
        }
        if (unitTo == 3) {
            result = result / 1852.0;
            System.out.format("%s %.3f", "Seemeilen", result);
        }
        if (unitTo == 4) {
            result = result / 0.9144;
            System.out.format("%s %.3f", "Yards", result);
        }
        if (unitTo == 5) {
            result = result / 0.0254;
            System.out.format("%s %.3f", "Inches", result);
        }
    }
}