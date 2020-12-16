/*
  print "Hello Universe"

  @author Tim Irmler (Zwazel)
  @since 2020-11-10
  @version 0.1
*/

package bzz.m403.universe;

import java.util.Scanner;

public class Universe { // NOTE public = jeder hat zugriff darauf
  /*
    Starts the execution

    @param args
              command line arguments
  */
  public static void main(String[] args) {
    Universe program = new Universe();
    program.run();
  }

  /*
    runs the program
  */
  private void run() { // Private = Keine andere Klasse hat darauf zugriff // Void = kein return
    String text; // NOTE Init String
    int repeat; // NOTE Init int

    Scanner scanner = new Scanner(System.in); // NOTE create new Scanner object called scanner
    System.out.print("Welcher Text soll angezeigt werden? "); // NOTE tell user what he has to do
    text = scanner.nextLine(); // NOTE get the input and store it in the variable

    System.out.print("Wie oft soll der Text angezeigt werden? "); // NOTE tell user what he has to do
    repeat = Integer.parseInt(scanner.nextLine()); // NOTE get the input and store it in the variable (as integer)

    for (int i = 0; i < repeat; i++) { // NOTE Repeat for as long as the user said we have to
      System.out.println(text); // NOTE gebe Text aus
    }
  }
}
