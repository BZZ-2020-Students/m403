package nikolaus;
import java.util.Scanner;

/**
 * Santa's naughty and nice list
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

        return -1;   // FIXME return the total points
    }

    /**
     * shows the verdict depending on the points total
     * @param points  the total points accumulated
     */
    private void verdict(double points) {

    }
}
