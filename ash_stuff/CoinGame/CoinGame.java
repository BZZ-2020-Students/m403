import java.util.Scanner;

/**
 * play a game with coins   ach ne
 *
 * @author Alyssa Heimöicher
 * @since 2020-12-07
 * @version 1.0
 */
public class CoinGame{

    static Scanner scanner;

    /**
     * constructor
     */
    public CoinGame() {
        scanner = new Scanner(System.in);
    }

    /**
     * starts the execution
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        CoinGame program = new CoinGame();

        System.out.println("Welcome to CoinGame");
        program.play();
        System.out.println("Sayonara");
        scanner.close();
    }

    /**
     * play the coin game
     */
    private void play() {
        // TODO Variablen deklarieren
        int currentPlayer = 1;
        int amtCoins = 0;
        int takenCoins = 0;
        // TODO aktueller Spieler gleich 1

        /* generate random number of coins
           between 10 and 30 */
        amtCoins = (int)(Math.random() * 20 + 10);

        // TODO Solange Restliche Münzen grösser Null
        while (amtCoins > 0){

            System.out.println("There are " + amtCoins + " left." );
            System.out.println("Player " + currentPlayer + ": Take one to three coins: ");
            takenCoins = scanner.nextInt();
            while(takenCoins < 1 || takenCoins > 3) {
              if(takenCoins < 1) {
                System.out.println("Error. Number to low");
              } else if(takenCoins > 3) {
                System.out.println("Error. Number too high");
              }
                System.out.println("Player " + currentPlayer + ": Take one to three coins: ");
                takenCoins = scanner.nextInt();
            }
            amtCoins -= takenCoins;
            switch (currentPlayer){
              case 1:
                currentPlayer = 2;
                break;

              case 2:
                currentPlayer = 1;
                break;
            }
        }
        System.out.println("The loser is Player " + currentPlayer);
            // TODO Ausgabe: Restliche Münzen
            // TODO Ausgabe: aktueller Spieler nimm 1-3 Münzen
            // TODO Eingabe: Anzahl Münzen

            // TODO Falls Anzahl Münzen kleiner 1

            // TODO Sonst
                // TODO Falls Anzahl Münzen grösser 3
                    // TODO Ausgabe: Du kannst höchstens 3 Münzen nehme
                // TODO Sonst
                    // TODO Reduziere Restliche Münzen um Anzahl
                    // TODO Aktueller Spieler = 3 - Aktueller Spieler
                // Ende der inneren Selektion
            // Ende der äusseren Selektion
       // Ende der Iteration
      // TODO Ausgabe: aktueller Spieler hat verloren
    }
}
