/* M403
*
*@author Alyssa Heimlicher
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner;

public class Rechner {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Rechner program = new Rechner();
    program.run();
  }

  /**/
  private void run() {
    Scanner input = new Scanner(System.in);

    //input to first integer
    System.out.println("Enter an integer: ");
    int firstInt = input.nextInt();

    //input to second integer
    System.out.println("Enter another integer: ");
    int secondInt = input.nextInt();

    //closes the scanner
    input.close();

    int result = firstInt * secondInt;

    System.out.println(firstInt + " * " + secondInt + " = " + result);
  }
}