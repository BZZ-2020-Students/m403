
import java.util.Scanner;

/**
 * show the salutations depending on gender
 *
 * @author Tim Irmler
 * @since 2020.11.24
 * @version 1.0
 */
public class Anrede {

    static Scanner scanner;
    /**
     * constructor
     */
    public Anrede() {
        scanner = new Scanner(System.in);
    }

    /**
     * starts the execution
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Anrede program = new Anrede();

        System.out.println("Willkommen");
        program.salute();
        System.out.println("\nUf Wiederluege!");
        scanner.close();
    }

    /**
     * enter the gender and show the salutations
     */
    private void salute() {
        char gender = '0';

        while (gender != 'x' && gender != 'X') {
            System.out.println("Geschlecht (W oder M / X = Ende) >");
            gender = scanner.next().charAt(0);

            switch (gender) {
                case 'W':
                case 'w':
                    System.out.println("Sehr geehrte Frau");
                    System.out.println("Chère madame");
                    System.out.println("Dear Mrs.");
                    break;

                case 'm':
                case 'M':
                    System.out.println("Sehr geehrter Herr");
                    System.out.println("Cher monsieur");
                    System.out.println("Dear Mr.");
                    break;
            }
        }
    }
}