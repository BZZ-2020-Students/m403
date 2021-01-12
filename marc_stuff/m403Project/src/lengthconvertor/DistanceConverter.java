package lengthconvertor;

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
        DistanceConverter program = new DistanceConverter();
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

        String[] units = new String[]{"meters", "miles", "nautical miles", "yards", "inches"};
        double[][] values = new double[][]{
                {1.0, 0.000621371, 0.0005399, 1.09361, 39.3701},
                {1609.34, 1.0, 0.868976, 1760.0, 63360.0},
                {1852.216, 1.15078, 1.0, 2025.37, 72913.4},
                {0.9144, 0.000568182, 0.000493737, 1.0, 36},
                {0.0254, 0.000015783, 0.000013715, 0.0277778, 1.0},
        };


        while (length <= 0) {
            System.out.print("Länge >");
            while (!scanner.hasNextDouble()) {
                System.out.println("Länge muss eine positive Zahl sein.");
                scanner.nextLine();
                System.out.print("Länge >");
            }
            length = scanner.nextDouble();
            if (length <= 0) {
                System.out.println("Länge muss eine positive Zahl sein.");
                length = 0;
            }
        }

        System.out.println("Zulässige Einheiten für die Umrechnung:");
        for (int i = 0; i < units.length; i++) {
            System.out.print(units[i] + " = " + (i + 1) + ", ");
        }
        System.out.println();
        while (unitFrom == -1) {
            System.out.print("Einheit von (1-5) >");
            while (!scanner.hasNextInt()) {
                System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                scanner.nextLine();
                System.out.print("Einheit von (1-5) >");
            }
            unitFrom = scanner.nextInt();
            if (unitFrom < 1 || unitFrom > 5) {
                unitFrom = -1;
                System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
            }
        }

        while (unitTo == -1) {
            System.out.print("Einheit nach (1-5) >");
            while (!scanner.hasNextInt()) {
                System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                scanner.nextLine();
                System.out.print("Einheit nach (1-5) >");
            }
            unitTo = scanner.nextInt();
            if (unitTo < 1 || unitTo > 5) {
                unitTo = -1;
                System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
            }
        }

        double result = length * values[unitFrom - 1][unitTo - 1];
        System.out.println(length + " " + units[unitFrom - 1] + " in " + units[unitTo - 1] + " is: " + result);
    }
}
