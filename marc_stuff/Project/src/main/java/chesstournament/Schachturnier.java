/* M403
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner;

public class Schachturnier {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Schachturnier program = new Schachturnier();
    program.run();
  }

  /**/
  private void run() {
    float pointsPlayer1 = 0;
    float pointsPlayer2 = 0;
    int gamesPlayed = 0;

    final int MAX_GAMES = 5;

    do {
      Scanner input = new Scanner(System.in);
      System.out.print("Wer hat gewonnen? (0/1/2) ");
      int winner = Integer.parseInt(input.nextLine());

    while (winner > 2 || winner < 0) {
      System.out.println("0, 1 or 2!");
      System.out.println("Who has won? 0,1,2");
      winner = Integer.parseInt(input.nextLine());
    }

    switch(winner) {
      case 1:
        pointsPlayer1++;
        break;

      case 2:
        pointsPlayer2++;
        break;
      case 0:
        pointsPlayer2 += 0.5;
        pointsPlayer1 += 0.5;
        break;
    }
    gamesPlayed++;
  } while(gamesPlayed < MAX_GAMES && pointsPlayer1 < 3 && pointsPlayer2 < 3);
    if (pointsPlayer2 == pointsPlayer1) {
      System.out.println("Unentschieden");
    }
    else if (pointsPlayer1 > 2) {
      System.out.println("Spieler 1 hat gewonnen!");
    }
    else if (pointsPlayer2 > 2) {
      System.out.println("Spieler 2 hat gewonnen!");
    }
  }
}
