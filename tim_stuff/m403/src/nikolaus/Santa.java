package nikolaus;
import java.util.Scanner;

/**
 * Santa's naughty and nice list
 * @author Zwazel
 */
public class Santa {
    private static Scanner scanner;
    /**
     * constructor: initialize attributes
     */
    private Santa() {
        scanner = new Scanner(System.in);
    }

    /**
     * starts the execution
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Santa program = new Santa();
        System.out.println("Herzliche Willkommen, lieber Nikolaus");

        double total = program.deeds();
        program.verdict(total);

        scanner.close();
    }

    /**
     * enter points for good/bad deeds
     * @return the total points
     */
    private double deeds() {
        double total = 0;
        double punkte = -999;
        while (total >= -20 && punkte != 0) {
            System.out.printf("Geben Sie die Anzahl Punkte an, 0 um zu beenden: ");
            punkte = scanner.nextDouble();
            total += punkte;
            if (punkte > 0) {
                System.out.println("Eine gute Tat");
            } else {
                System.out.println("Eine böse Tat");
            }
            System.out.println("Zwischentotal: " + total);
        }
        System.out.println("Total: " + total);
        return total;
    }

    /**
     * shows the verdict depending on the points total
     * @param points  the total points accumulated
     */
    private void verdict(double points) {
        if (points < 0) {
            System.out.println("Ein unartiges Kind");
        } else if (points < 9.5) {
            System.out.println("Ein etwas artiges Kind");
        } else if (points < 15) {
            System.out.println("Ein artiges Kind");
        } else {
            System.out.println("Ein braves Kind");
        }
    }
}
