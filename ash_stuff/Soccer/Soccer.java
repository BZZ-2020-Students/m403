import java.util.Scanner;

/**
 * enter and rate soccer players
 *
 * @author Alyssa Heimlicher
 * @version 1.0
 * @since 2020-12-1
 */
public class Soccer {

    Scanner scanner;

    /**
     * constructor
     */
    public Soccer () {
        scanner = new Scanner (System.in);
    }

    /**
     * starts the execution
     *
     * @param args command line arguments
     */
    public static void main (String[] args) {
        Soccer program = new Soccer ();

        System.out.println ("Willkommen beim Soccer Manager");
        program.ratePlayers ();
        System.out.println ("c u l8er, aligator");
    }

    /**
     * enter the rating for the players
     */
    private void ratePlayers () {

        // TODO start declaration

        // TODO end declaration

        System.out.print ("Trikotnummer (1 - 99 / 0=Ende) >=");

		int shirtNo = 0;
		double totalRating = 0;
		int countRating = 0;
		double rating = 0;

        shirtNo = scanner.nextInt ();
        while (shirtNo != 0) {
            totalRating = 0.0;
            countRating = 0;
            System.out.print ("Bewertung (1.0 - 6.0 / 0=Ende) >");
            rating = scanner.nextDouble ();

            while (rating > 0) {
                totalRating = totalRating + rating;
                countRating = countRating + 1;
                System.out.print ("Bewertung (1.0 - 6.0 / 0=Ende) >");
                rating = scanner.nextDouble ();
            }
            System.out.println ("Spieler: " + shirtNo + " / Durchschnitt: " + (totalRating / countRating));

            System.out.print ("Trikotnummer (1 - 99 / 0=Ende) >");
            shirtNo = scanner.nextInt ();
        }

        scanner.close ();
    }
}
