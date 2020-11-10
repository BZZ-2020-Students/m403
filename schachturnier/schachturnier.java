/*
  schachturnier

  @author Tim Irmler (Zwazel)
  @since 2020-11-10
  @version 0.1
*/

import java.util.Scanner;

public class schachturnier { // NOTE public = jeder hat zugriff darauf
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    schachturnier program = new schachturnier();
    program.run();
  }

  /*
    runs the program
  */
  private void run() { // Private = Keine andere Klasse hat darauf zugriff // Void = kein return
    int winner; // NOTE Init String

    float firstPlayerPoints = 0;
    float secondPlayerPoints = 0;
    int timesPlayed = 0;

    final int WIN_POINTS = 1;
    final float DRAW_POINTS = (float) 0.5;
    final int MAX_ROUNDS = 5;

    do {
      Scanner scanner = new Scanner(System.in); // NOTE create new Scanner object called scanner
      System.out.print("Welcher Spieler hat gewonnen? (0/1/2) "); // NOTE tell user what he has to do
      winner = Integer.parseInt(scanner.nextLine()); // NOTE get the input and store it in the variable (as integer)

      while (winner > 2 || winner < 0) {
        System.out.print("Eingabe ist nicht korrekt, bitte gib entweder 0, 1 oder 2 ein! "); // NOTE tell the user he made a mistake -_-
        System.out.print("Welcher Spieler hat gewonnen? (0/1/2) "); // NOTE tell user what he has to do
        winner = Integer.parseInt(scanner.nextLine()); // NOTE get the input and store it in the variable (as integer)
      }

      switch (winner) {
        case 1:
          firstPlayerPoints += WIN_POINTS;
          break;

        case 2:
          secondPlayerPoints += WIN_POINTS;
          break;

        default:
          firstPlayerPoints += DRAW_POINTS;
          secondPlayerPoints += DRAW_POINTS;
          break;
      }
      timesPlayed++;
    } while (timesPlayed < MAX_ROUNDS);

    if (firstPlayerPoints > secondPlayerPoints) {
      System.out.print("Spieler 1 hat gewonnen!");
    } else if (firstPlayerPoints < secondPlayerPoints) {
      System.out.print("Spieler 2 hat gewonnen!");
    } else {
      System.out.print("Unentschieden!");
    }
  }
}
