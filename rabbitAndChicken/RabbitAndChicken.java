/*
  Count the amount of rabbits and chickens

  @author Tim Irmler (Zwazel)
  @since 2020-11-10
  @version 0.1
*/

import java.util.Scanner;

public class RabbitAndChicken {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    RabbitAndChicken program = new RabbitAndChicken();
    program.run();
  }

  /*
    runs the program
  */
  private void run() {
    int countRabbit = 0;
    int countChicken = 0;
    int countLegs = 0;

    int currentCountLegs = 0;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Wieviele Beine hast du gezaehlt? ");
    countLegs = Integer.parseInt(scanner.nextLine());

    while ((countLegs % 2) > 0) {
      System.out.print("Die Anzahl der Beine darf nicht ungerade sein! ");

      System.out.print("\nWieviele Beine hast du gezaehlt? ");
      countLegs = Integer.parseInt(scanner.nextLine());
    }

    System.out.print("Wieviele Tiere hast du gezaehlt? ");
    countRabbit = Integer.parseInt(scanner.nextLine());

    do {
      currentCountLegs = (4 * countRabbit) + (2 * countChicken);

      if (currentCountLegs > countLegs) {
        countRabbit--;
        countChicken++;
      }
    } while (currentCountLegs > countLegs);

    System.out.println("Anzahl Hasen: " + countRabbit);
    System.out.println("Anzahl Huehner: " + countChicken);
  }
}
