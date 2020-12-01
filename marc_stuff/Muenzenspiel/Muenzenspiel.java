import java.util.Scanner;

/**
 * play a game with coins
 *
 * @author Marcel Suter
 * @since 2018-09-28
 * @version 1.0
 */
public class Muenzenspiel{

    static Scanner scanner;

    /**
     * constructor
     */
    public Muenzenspiel() {
        scanner = new Scanner(System.in);
    }

    /**
     * starts the execution
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Muenzenspiel program = new Muenzenspiel();

        System.out.println("Willkommen zum Münzenspiel");
        program.play();
        System.out.println("Bis bald");
        scanner.close();
    }

    /**
     * play the coin game
     */
    private void play() {
        // TODO Variablen deklarieren
        int currentPlayer = 1;
        int coinsAmount = 0;
        int coinsTaken = 0;

        /* generate random number of coins
           between 10 and 30 */
        coinsAmount = (int)(Math.random() * 20 + 10);

        while (coinsAmount > 0 ) {
          do {
            System.out.println("Currently there are " + coinsAmount + " coins!");
            System.out.print("Player 1: How many coins do you want to take (1-3): ");
            coinsTaken = scanner.nextInt();
            if (coinsTaken < 1) {
              System.out.println("You need to take at least 1 coin!");
            } else if (coinsTaken > 3) {
              System.out.println("You can only take a maximum of 3 coins!");
            } else {
              coinsAmount -= coinsTaken;
            }
            currentPlayer = 1;
          } while (coinsTaken < 1 || coinsTaken > 3);
          if (coinsAmount < 1) {
            break;
          }

          do {
            System.out.println("Currently there are " + coinsAmount + " coins!");
            System.out.print("Player 2: How many coins do you want to take (1-3): ");
            coinsTaken = scanner.nextInt();
            if (coinsTaken < 1) {
              System.out.println("Player 2: You need to take at least 1 coin!");
            } else if (coinsTaken > 3) {
              System.out.println("Player 2: You can only take a maximum of 3 coins!");
            }
            else {
              coinsAmount -= coinsTaken;
            }
            currentPlayer = 2;
          } while (coinsTaken < 1 || coinsTaken > 3);
        }

        if (currentPlayer == 1) {
          System.out.println("Player 1 wins!");
        }
        else if (currentPlayer == 2) {
          System.out.println("Player 2 wins!");
        }
    }
}
