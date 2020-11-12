/*
  Multiply a given number with 23

  @author Tim Irmler (Zwazel)
  @since 2020-11-12
  @version 0.1
*/

import java.util.Scanner;

public class multiplikation {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    multiplikation program = new multiplikation();
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
