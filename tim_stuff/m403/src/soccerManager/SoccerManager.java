package soccerManager;

import java.util.Scanner;

/**
 * enter and rate soccer players
 *
 * @author Tim Irmler
 * @version 1.0
 * @since 2020-11-24
 */
public class SoccerManager {

    Scanner scanner;

    /**
     * constructor
     */
    public SoccerManager() {
        scanner = new Scanner (System.in);
    }

    /**
     * starts the execution
     *
     * @param args command line arguments
     */
    public static void main (String[] args) {
        SoccerManager program = new SoccerManager();

        System.out.println ("Willkommen beim Soccer Manager");
        program.ratePlayers ();
        System.out.println ("c u l8er, aligator");
    }

    /**
     * enter the rating for the players
     */
    private void ratePlayers () {
        int shirtNo;
        int countRating;

        double totalRating;
        double rating;

        System.out.print ("Trikotnummer (1 - 99 / 0=Ende) >");
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
