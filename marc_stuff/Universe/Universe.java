/* M403 1b
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner; //Imports the Scanner (class)

public class Universe {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Universe program = new Universe();
    program.run();
  }

  /* prints out Hello Universe*/
  private void run() {

    //scans the input
    Scanner input = new Scanner(System.in);
    System.out.println("Enter some text: ");

    //adds input to string
    String outputText = input.nextLine();

    //closes the scanner
    input.close();

    //prints line without content
    System.out.println();

    //prints out the input 5x
    for (int i = 1; i <= 5; i++) {
      System.out.println("Your input is: " + outputText);
    }
  }
}
