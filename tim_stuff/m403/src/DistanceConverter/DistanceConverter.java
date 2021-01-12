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

    double[] multiplicator = {1,1609.34,1852.0,0.9144,0.0254};
    String[] distanceType = {"Meter","Meilen","Seemeilen","Yards","Inches"};
    int[] units = new int[2];

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
        double length = getLength();
        units[0] = getUnits("von");
        units[1] = getUnits("nach");

        System.out.format("%f ", length);
        System.out.print (distanceType[units[0]]);
        double result = length * multiplicator[units[0]];

        System.out.print(" entspricht ");
        System.out.format("%s %.3f", distanceType[units[1]], result);
    }

    private int getUnits(String vonOrNach) {
        System.out.println("Zulässige Einheiten für die Umrechnung:");
        System.out.println("1=" + distanceType[0] + ", 2=" + distanceType[1] + ", 3=" + distanceType[2] + ", 4=" + distanceType[3] + ", 5=" + distanceType[4]);
        int unit = -1;
        while (unit == -1) {
            System.out.print("Einheit " + vonOrNach + " (1-5) >");
            while (!scanner.hasNextInt ()) {
                System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                scanner.nextLine();
                System.out.print("Einheit " + vonOrNach + " (1-5) >");
            }
            unit = scanner.nextInt ();
            if (unit < 1 || unit > 5) {
                unit = -1;
                System.out.println ("Unbekannte Einheit. Bitte 1-5 eingeben.");
            }
        }

        return unit-1;
    }

    private double getLength() {
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

        return length;
    }
}