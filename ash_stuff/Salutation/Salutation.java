import java.util.Scanner;

/**
 * show the salutations depending on gender
 *
 * @author Alyssa Heimlicher
 * @since 2020-12-01
 * @version 1.0
 */
public class Salutation {

    static Scanner scanner;
    /**
     * constructor
     */
    public Salutation() {
        scanner = new Scanner(System.in);
    }

    /**
     * starts the execution
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Salutation program = new Salutation();

        System.out.println("Willkommen");
        program.salute();
        System.out.println("\nUf Wiederluege!");
        scanner.close();
    }

    /**
     * enter the gender and show the salutations
     */
    private void salute() {
        // TODO-1 Variablen deklarieren
        char gender = ' ';
        Scanner sc = new Scanner(System.in);
        // TODO-2.1 Ausgabe "Geschlecht (W oder M / X=Ende) >"
        do {
          System.out.print("Enter a gender: (M/F/ X = Ende) ");
          gender = sc.next().charAt(0);
        } while (gender != 'F' && gender != 'M' && gender != 'X');

        if (gender == 'F') {
          System.out.println("D: Sehr geehrte Frau \nF: Chere madame \nE: Dear Mrs.");
        } else if(gender == 'M'){
          System.out.print("D: Sehr geehrter Herr \nF: Cher monsieur \nE: Dear Mr. ");
        }
        else if(gender == 'X'){
          return;
        }
    }
}
