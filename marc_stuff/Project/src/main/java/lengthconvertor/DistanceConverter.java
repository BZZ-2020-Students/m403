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
    double length;
    int unitFrom;
    int unitTo;
    String[] units;
    double[][] values;
    double result;

    // declare attributes
    static Scanner scanner;

    /**
     * constructor: initialize attributes
     */
    public DistanceConverter() {
        scanner = new Scanner(System.in);
        length = 0;
        unitFrom = -1;
        unitTo = -1;
        length = 0;
        units = new String[]{"meters", "miles", "nautical miles", "yards", "inches"};
        values = new double[][]{
                {1.0, 0.000621371, 0.0005399, 1.09361, 39.3701},
                {1609.34, 1.0, 0.868976, 1760.0, 63360.0},
                {1852.216, 1.15078, 1.0, 2025.37, 72913.4},
                {0.9144, 0.000568182, 0.000493737, 1.0, 36},
                {0.0254, 0.000015783, 0.000013715, 0.0277778, 1.0},
        };
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
        getLength();
        printInfo();
        getUnitFrom();
        getUnitTo();
        calculateResult();
        printResult();
    }

    private void getLength() {
        while (this.length <= 0) {
            System.out.print("Length > ");
            while (!scanner.hasNextDouble()) {
                System.out.println("The length needs to be a positive number!");
                scanner.nextLine();
                System.out.print("Length > ");
            }
            this.length = scanner.nextDouble();
            if (this.length <= 0) {
                System.out.println("The length needs to be a positive number!");
                this.length = 0;
            }
        }
    }

    private void getUnitFrom() {
        while (this.unitFrom == -1) {
            System.out.print("Unit from (1-5) > ");
            while (!scanner.hasNextInt()) {
                System.out.println("Unknown Unit. Please enter 1-5.");
                scanner.nextLine();
                System.out.print("Unit from (1-5) > ");
            }
            this.unitFrom = scanner.nextInt();
            if (this.unitFrom < 1 || this.unitFrom > 5) {
                this.unitFrom = -1;
                System.out.println("Unknown Unit. Please enter 1-5.");
            }
        }
    }

    private void getUnitTo() {
        while (this.unitTo == -1) {
            System.out.print("Unit to (1-5) > ");
            while (!scanner.hasNextInt()) {
                System.out.println("Unknown Unit. Please enter 1-5.");
                scanner.nextLine();
                System.out.print("Unit to (1-5) > ");
            }
            this.unitTo = scanner.nextInt();
            if (this.unitTo < 1 || this.unitTo > 5) {
                this.unitTo = -1;
                System.out.println("Unknown Unit. Please enter 1-5.");
            }
        }
    }

    private void printInfo() {
        System.out.println("Allowed Units for conversion : ");
        for (int i = 0; i < units.length; i++) {
            System.out.print(units[i] + " = " + (i + 1) + ", ");
        }
        System.out.println();
    }

    private void calculateResult() {
        this.result = length * values[unitFrom - 1][unitTo - 1];
    }

    private void printResult() {
        System.out.println(length + " " + units[unitFrom - 1] + " in " + units[unitTo - 1] + " is: " + result);
    }
}
