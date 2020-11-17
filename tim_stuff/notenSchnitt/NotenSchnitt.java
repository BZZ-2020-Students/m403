/*
  Calculate the average of the marks

  @author Tim Irmler (Zwazel)
  @since 2020-11-17
  @version 0.1
*/

import java.util.Scanner;

public class NotenSchnitt {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    NotenSchnitt program = new NotenSchnitt();
    program.run();
  }

  /*
    Berechnet die Quersumme einer uebergebenen Zahl
  */
  private void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Wie viele LBs willst du eingeben? ");
    int amountMarcs = scanner.nextInt();

    float summeNoten = 0;

  	for (int i = 0; i < amountMarcs; i++) {
      System.out.print("Note " + (i+1) + ": ");
      float note = scanner.nextFloat();

      while (note < 1 || note > 6) {
        System.out.println("Die Note muss zwischen 1 und 6 liegen");
        System.out.print("Note " + (i+1) + ": ");
        note = scanner.nextFloat();
      }

      summeNoten += note;
    }

    float durchschnitt = summeNoten/amountMarcs;

    System.out.print("Durchschnitt = " + durchschnitt);
  }
}
