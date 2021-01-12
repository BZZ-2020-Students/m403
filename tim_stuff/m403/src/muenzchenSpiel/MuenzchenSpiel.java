package muenzchenSpiel;

import java.util.Scanner;

/**
 * play a game with coins
 *
 * @author Tim Irmler
 * @since 2020.11.24
 * @version 1.0
 */
public class MuenzchenSpiel {

    static Scanner scanner;

    /**
     * constructor
     */
    public MuenzchenSpiel() {
        scanner = new Scanner(System.in);
    }

    /**
     * starts the execution
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        MuenzchenSpiel program = new MuenzchenSpiel();

        System.out.println("Willkommen zum Münzenspiel");
        program.play();
        System.out.println("Bis bald");
        scanner.close();
    }

    /**
     * play the coin game
     */
    private void play() {
        final int minRemoveAmountCoins = 1;
        final int maxRemoveAmountCoins = 3;

        int currentPlayer = (int)(Math.random() * 2 + 1);

        /* generate random number of coins
           between 10 and 30 */
        int restCoins = (int)(Math.random() * 20 + 10);

        while (restCoins > 0) {
            currentPlayer = 3 - currentPlayer;

            System.out.println("Restliche Münzen: " + restCoins);
            System.out.print("Spieler " + currentPlayer + " nimm 1-3 Münzen ");
            int removeCoinsAmount = scanner.nextInt();

            while (removeCoinsAmount > maxRemoveAmountCoins || removeCoinsAmount < minRemoveAmountCoins) {
                if (removeCoinsAmount < minRemoveAmountCoins) {
                    System.out.println("Du musst mindestens 1 Münze nehmen");
                    System.out.print("Spieler " + currentPlayer + " nimm 1-3 Münzen ");
                    removeCoinsAmount = scanner.nextInt();
                } else if (removeCoinsAmount > maxRemoveAmountCoins) {
                    System.out.println("Du kannst höchstens 3 Münzen nehmen");
                    System.out.print("Spieler " + currentPlayer + " nimm 1-3 Münzen ");
                    removeCoinsAmount = scanner.nextInt();
                }
            }
            restCoins -= removeCoinsAmount;
        }
        System.out.println("Spieler " + currentPlayer + " hat verloren!!!");
    }
}
