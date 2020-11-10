/*
  Print all even numbers in a set range

  @author Tim Irmler (Zwazel)
  @since 2020-11-10
  @version 0.1
*/

import java.util.Scanner;

public class geradeZahlen {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    geradeZahlen program = new geradeZahlen();
    program.run();
  }

  /*
    runs the program
  */
  private void run() {
    int minNumber = 1;
    int maxNumber = 200;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Wo soll ich anfangen zu zaehlen? ");
    minNumber = Integer.parseInt(scanner.nextLine());

    System.out.print("Bis wohin soll ich zaehlen? ");
    maxNumber = Integer.parseInt(scanner.nextLine());

    while (maxNumber < minNumber) {
      System.out.print("Die zweite Zahl muss groesser sein wie die erste! ");

      System.out.print("Bis wohin soll ich zaehlen? ");
      maxNumber = Integer.parseInt(scanner.nextLine());
    }

    for (int i = minNumber; i <= maxNumber; i++) {
      if ((i % 2) == 0) {
        System.out.println(i);
      }
    }
  }
}
