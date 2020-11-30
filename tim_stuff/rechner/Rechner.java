/*
  multiply two given numbers together

  @author Tim Irmler (Zwazel)
  @since 2020-11-12
  @version 0.1
*/


import java.util.Scanner;

public class Rechner {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    Rechner program = new Rechner ();
    program.run();
  }

  /*
    Berechnet die Quersumme einer uebergebenen Zahl
  */
  private void run() {
    int firstNumber;
    int secondNumber;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Erste Zahl: ");
    firstNumber = Integer.parseInt(scanner.nextLine());

    System.out.print("Zweite Zahl: ");
    secondNumber = Integer.parseInt(scanner.nextLine());

		int summe = firstNumber * secondNumber;

    System.out.println(firstNumber + " * " + secondNumber + " = " + summe);
  }
}
