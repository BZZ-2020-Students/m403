
import java.util.Scanner;

public class HoelzchenSpiel {
    Scanner scanner = new Scanner(System.in);

    int anzahlHoelzchen = 21;
    int currentPlayer = 1;

    final int maxHoelzchen = 3;
    final int minHoelzchen = 1;

    public static void main(String[] args) {
        HoelzchenSpiel program = new HoelzchenSpiel();
        program.run();
    }

    public void run() {
        while (anzahlHoelzchen > 1) {
            int takeHoelzchen = howManyHoelzchen();

            while (takeHoelzchen > maxHoelzchen || takeHoelzchen < minHoelzchen) {
                System.out.println("Du darfst nicht mehr/weniger Hölzchen als " + minHoelzchen + " bzw " + maxHoelzchen + " nehmen!");
                takeHoelzchen = howManyHoelzchen();
            }

            anzahlHoelzchen -= takeHoelzchen;
            switchPlayer();
            System.out.print("\n\n");
        }

        //switchPlayer();
        System.out.print("\n\n");
        System.out.println("Spieler " + currentPlayer + " hat verloren!!");
    }

    private int howManyHoelzchen() {
        System.out.println("Es sind " + anzahlHoelzchen + " Hölzer vorhanden");
        System.out.println("Spieler " + currentPlayer + ": Wieviele Hölzer nimmst du? (1-3) ");
        return scanner.nextInt();
    }

    private void switchPlayer() {
        currentPlayer = 3 - currentPlayer;
    }
}
