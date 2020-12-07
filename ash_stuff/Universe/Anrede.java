/* M403
*
*@author Marc Andri Fuchs
*@since 2020-11-30
*@version 0.1
*/

import java.util.Scanner;

public class Anrede {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    System.out.println("Guete Tag!\n");
    Anrede program = new Anrede();
    program.run();
    System.out.println("\nAde merci!");
  }

  /**/
  private void run() {
    //Start of declaration
    char gender = ' ';
    Scanner sc = new Scanner(System.in);
    //End of declaration

    do {
      System.out.print("Enter a gender: (M/F) ");
      gender = sc.next().charAt(0);
    } while (gender != 'F' && gender != 'M' && gender != 'X');

    switch (gender) {
      case 'M':
        System.out.println("E: Dear Mr.");
        System.out.println("D: Sehr geehrter Herr");
        System.out.println("F: Cher monsieur");
        break;
      case 'F':
        System.out.println("E: Dear Mrs.");
        System.out.println("D: Sehr geehrte Frau");
        System.out.println("F: Chère madame");
        break;
      case 'X':
        System.out.println("Goodbye!");
        break;
    }
  }
}
