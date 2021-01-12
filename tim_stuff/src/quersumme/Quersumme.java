/*
  Calculate the "Quersumme" of a given number

  @author Tim Irmler (Zwazel)
  @since 2020-11-12
  @version 0.1
*/

package quersumme;

import java.util.Scanner;

public class Quersumme {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    Quersumme program = new Quersumme();
    program.run();
  }

  /*
    Berechnet die Quersumme einer uebergebenen Zahl
  */
  private void run() {
    int givenZahl;

    Scanner scanner = new Scanner(System.in);

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
