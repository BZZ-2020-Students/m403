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

    int givenZahl;

    System.out.print("Gib Zahl: ");
    givenZahl = Integer.parseInt(scanner.nextLine());

		int summe = 0;
    int zahl = givenZahl;
		while (0 != zahl) {
			// addiere die letzte ziffer der uebergebenen zahl zur summe
			summe = summe + (zahl % 10);
			// entferne die letzte ziffer der uebergebenen zahl
			zahl = zahl / 10;
		}

    System.out.println("Quersumme von " + givenZahl + " = " + summe);
  }
}
