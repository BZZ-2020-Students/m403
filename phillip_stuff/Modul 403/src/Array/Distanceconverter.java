package Array;
import java.util.Scanner;

public class Distanceconverter {

        // declare attributes
        static Scanner scanner;

        public Distanceconverter() {
            scanner = new Scanner(System.in);
        }


        public static void main(String[] args) {
            Distanceconverter program = new Distanceconverter();
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

            String einheit[] = {"Meter", "Meilen", "Seemeilen", "Yard", "Inches"};
            double berechnung[][] = {{1.0, 0.000621371, 0.0005399, 1.09361, 39.3701},
                    {1609.34, 1.0, 0.868976, 1760.0, 63360.0},
                    {1852.216, 1.15078, 1.0, 2025.37, 72913.4},
                    {0.9144, 0.000568182, 0.000493737, 1.0, 36},
                    {0.0254, 0.000015783, 0.000013715, 0.0277778, 1.0},
            };
            System.out.println("1 = " + einheit[0] + " 2 = " + einheit[1] + " 3 = " + einheit[2] + " 4 = " + einheit[3] + " 5 = " + einheit[4]);

            while (length <= 0) {
                System.out.print("Länge > ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Länge muss eine positive Zahl sein.");
                    scanner.nextLine();
                    System.out.print("Länge > ");
                }
                length = scanner.nextDouble();
                if (length <= 0) {
                    System.out.println("Länge muss eine positive Zahl sein.");
                    length = 0;
                }
            }

            System.out.println("Zulässige Einheiten für die Umrechnung:");
            System.out.println("1 = " + einheit[0] + " 2 = " + einheit[1] + " 3 = " + einheit[2] + " 4 = " + einheit[3] + " 5 = " + einheit[4]);
            while (unitFrom == -1) {
                System.out.print("Einheit von (1-5) > ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                    scanner.nextLine();
                    System.out.print("Einheit von (1-5) > ");
                }
                unitFrom = scanner.nextInt();
                if (unitFrom < 1 || unitFrom > 5) {
                    unitFrom = -1;
                    System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                }
            }

            while (unitTo == -1) {
                System.out.print("Einheit nach (1-5) > ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                    scanner.nextLine();
                    System.out.print("Einheit nach (1-5) > ");
                }
                unitTo = scanner.nextInt();
                if (unitTo < 1 || unitTo > 5) {
                    unitTo = -1;
                    System.out.println("Unbekannte Einheit. Bitte 1-5 eingeben.");
                }
            }

            double result = length;
            if (unitFrom == 2) {
                result = length * 1609.34;
            } else if (unitFrom == 3) {
                result = length * 1852.0;
            } else if (unitFrom == 4) {
                result = length / 0.9144;
            } else if (unitFrom == 5) {
                result = length / 0.0254;
            }

            if (unitTo == 2) {
                result = result / 1609.34;
            }
            if (unitTo == 3) {
                result = result / 1852.0;
            }
            if (unitTo == 4) {
                result = result * 0.9144;
            }
            if (unitTo == 5) {
                result = result * 0.0254;
            }
            System.out.println(length + " " + einheit[unitFrom - 1] + " entspricht " + result + " " + einheit[unitTo - 1]);

        }
    }

