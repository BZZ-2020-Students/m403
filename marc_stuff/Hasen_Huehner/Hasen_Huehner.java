/* M403
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner;

public class Hasen_Huehner {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Hasen_Huehner program = new Hasen_Huehner();
    program.run();
  }

  /* prints out Hello Universe*/
  private void run() {
    int bunny = 0;
    int chicken = 0;

    Scanner input = new Scanner(System.in);
    System.out.println("Wieviele Beine sind es?");
    int legs = input.nextInt();
    System.out.println("Wieviele Tiere sind es?");
    int animals = input.nextInt();

    if (!(legs % 2 == 0)) {
      System.out.println("This number is not a multiple of 2!");
    }

    else if (animals > legs/2) {
      System.out.println("You cant have more animals than half of the legs!");
    }

    else if (legs > animals*4) {
      System.out.println("You cant habe more legs than 4x the amount of animals!");
    }

    else if (true) {

      bunny = animals;
      chicken = 0;

      for (int i = animals * 4; i > legs; i = i-2) {
        bunny = bunny-1;
        chicken = chicken+1;
      }

      System.out.println("Du hast " + bunny + " Hasen und " + chicken + " Huehner!");
    }

    input.close();
  }
}
