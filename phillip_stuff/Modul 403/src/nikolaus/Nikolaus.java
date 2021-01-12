package nikolaus;
import java.util.Scanner;

public class Nikolaus {


    /**
     * Santa's naughty and nice list
     * Phillip Jerebic
     */


    private static Scanner scanner;

    private Nikolaus() {
        scanner = new Scanner(System.in);
    }


    public static void main(String[] args) {
        Nikolaus program = new Nikolaus();
        System.out.println("Herzliche Willkommen, lieber Nikolaus");

        double total = program.deeds();
        program.verdict(total);

        scanner.close();
    }

    private double deeds() {
        double total = 0;
        double punkte = 2;

        while (total >= -20 && punkte != 0) {
            System.out.println("Eingabe Punkte: ");


            while (scanner.hasNextDouble() == false) {                // Solange keine Dezimalzahl eingegeben wurde
                System.out.println("Das ist keine Zahl. Punkte >");    // Schreibe eine Fehlermeldung
                scanner.next();                                        // Lösche die Eingabe aus dem Scanner
            }
            punkte = scanner.nextDouble();
            total += punkte;

            if (punkte > 0) {
                System.out.println("Eine gute Tat!");
            } else {
                System.out.println("Eine böse Tat!");
            }

            runden(total);

        }
        return total;
    }



        private double runden(double total){
            int gerundet;
            System.out.println("Vor dem Runden: " + total);
            total = total + 0.25;
            total = total*2;
            gerundet = (int)total;
            gerundet = gerundet / 2;
            total = gerundet;
            System.out.println("Nach dem Runden: " + total);

            return total;
        }
        private void verdict(double punkte) {

            if(punkte < 0)
            {
                System.out.println("Ein unartiges Kind");
            } else if (punkte > 0 && punkte < 9.5)
            {
                System.out.println("Ein etwas artiges Kind");
            } else if (punkte < 15)
            {
                System.out.println("Ein artiges Kind");
            }else
            {
                System.out.println("Ein braves Kind");
            }
        }
    }




