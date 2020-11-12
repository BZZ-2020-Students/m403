/*
  Calculate the "Quersumme" of a given number

  @author Tim Irmler (Zwazel)
  @since 2020-11-12
  @version 0.1
*/

import java.util.Scanner;

public class quersumme {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    quersumme program = new quersumme();
    program.run();
  }

  /*
    runs the program
  */
  private void run() {
    String givenText;
    int countLetters = 0;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Gib die Zahl ein: ");
    givenText = scanner.nextLine();

    for (;  countLetters < givenText.length(); countLetters++) {

    }

    System.out.println("Dein Wort hat " + countLetters + " Buchstaben");
  }
}
