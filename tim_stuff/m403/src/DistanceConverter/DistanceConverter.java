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
        double[] multiplicator = {1,1609.34,1852.0,0.9144,0.0254};
        String[] distanceType = {"Meter","Meilen","Seemeilen","Yards","Inches"};
        unitFrom--;
        System.out.print (distanceType[unitFrom]);
        result = length * multiplicator[unitFrom];

        System.out.print(" entspricht ");
        unitTo--;
        System.out.format("%s %.3f", distanceType[unitTo], result);
    }
}