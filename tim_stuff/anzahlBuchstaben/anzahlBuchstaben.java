/*
  Count the letters in a given word

  @author Tim Irmler (Zwazel)
  @since 2020-11-12
  @version 0.1
*/

import java.util.Scanner;

public class anzahlBuchstaben {
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    anzahlBuchstaben program = new anzahlBuchstaben();
    program.run();
  }

  /*
    runs the program
  */
  private void run() {
    String givenText;
    int countLetters = 0;

    Scanner scanner = new Scanner(System.in);

    System.out.print("Gib den Text ein: ");
    givenText = scanner.nextLine();

    for (;  countLetters< givenText.length(); countLetters++) {

    }

    System.out.println("Dein Wort hat " + countLetters + " Buchstaben");
  }
}
