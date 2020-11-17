/*
  Multiply a given number with 23

  @author Tim Irmler (Zwazel)
  @since 2020-11-12
  @version 0.1
*/

import java.util.Scanner;

public class Multiplikation {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    Multiplikation program = new Multiplikation();
    program.run();
  }

  /*
    runs the program
  */
  private void run() {
    int givenNumber;
    final int multiply = 23;
    int calculatedNumber;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Gib Zahl: ");
    givenNumber = Integer.parseInt(scanner.nextLine());

    int result = givenNumber * multiply;

    System.out.println(givenNumber + " * " + multiply + " = " + result);
  }
}
