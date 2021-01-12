package santa;

import java.util.Scanner;

/**
 * santa.Santa's naughty and nice list
 *
 * @author TODO
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
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Santa program = new Santa();
        double total = 0;
        System.out.println("Herzliche Willkommen, lieber Nikolaus");

        total = program.deeds();
        program.verdict(total);

        scanner.close();
    }

    /**
     * enter points for good/bad deeds
     *
     * @return the total points
     */
    private double deeds() {
        double total = 0;
        double points = 999;
        while (total >= -20 && points != 0) {
            scanner = new Scanner(System.in);
            System.out.println("Enter the amount of points the CHILD gets (-6 to 6) : ");
            while (!scanner.hasNextDouble()) {
                System.out.println("This is not a valid number. Try again > ");
                scanner.next();
            }
            points = scanner.nextDouble();
            total += points;
            if (points >= 0)
                System.out.println("A good deed!");
            else
                System.out.println("A bad deed!");
        }
        total = roundPoints(total);
        return total;
    }

    private double roundPoints(double input) {
        int rounded = (int) ((input + 0.25) * 2);
        return rounded / 2f;
    }

    /**
     * shows the verdict depending on the points total
     *
     * @param points the total points accumulated
     */
    private void verdict(double points) {
        System.out.println("This child has " + points + " points!");
        if (points < 0)
            System.out.println("A naughty child");
        else if (points < 9.5)
            System.out.println("A somewhat well-behaved child!");
        else if (points < 15)
            System.out.println("A well-behaved child!");
        else
            System.out.println("A good child!");
    }
}
