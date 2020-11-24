/* M403
*
*@author Marc Andri Fuchs
*@since 2020-11-22
*@version 0.1
*/

import java.util.Scanner;

public class HoelzchenSpiel {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    HoelzchenSpiel program = new HoelzchenSpiel();
    program.run();
  }

  /**/
  private void run() {
    int StickCount = 21;
    int player1pick = 0;
    int player2pick = 0;

    String lastPick = "";

    while (StickCount <= 21) {
      Scanner sc = new Scanner(System.in);

      //Player 1
      System.out.println("Player 1: How many matchsticks do you want to take? (1,2,3)");
      int input = sc.nextInt();
      if (input < 1 || input > 3) {
        System.out.println("This in not a valid number please enter 1,2 or 3!");
      }else if (input > StickCount) {
        System.out.println("The maximum amount of matchsticks you can take is " + StickCount);
      } else {
        player1pick = input;
        StickCount -= player1pick;
        lastPick = "player1";
        System.out.println("You took " + player1pick + " matchsticks!");
        System.out.println("There are " + StickCount + " remaining!");
      }

      if (StickCount == 1) {
        break;
      }

      //Player 2
      System.out.println("Player 2: How many matchsticks do you want to take? (1,2,3)");
      input = sc.nextInt();
      if (input < 1 || input > 3) {
        System.out.println("This in not a valid number please enter 1,2 or 3!");
      } else if (input > StickCount) {
        System.out.println("The maximum amount of matchsticks you can take is " + StickCount);
      } else {
        player2pick = input;
        StickCount -= player2pick;
        lastPick = "player2";
        System.out.println("You took " + player2pick + " matchsticks!");
        System.out.println("There are " + StickCount + " remaining!");
      }

      if (StickCount == 1) {
        break;
      }
    }

    if (lastPick.equalsIgnoreCase("player1")) {
      System.out.println("Player 1 has won the game!");
    } else if (lastPick.equalsIgnoreCase("player2")) {
      System.out.println("Player 2 has won the game!");
    }

    sc.close();
  }
}
