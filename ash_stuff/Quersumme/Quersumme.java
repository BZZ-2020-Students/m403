/* M403
*
*@author Alyssa Heimlicher
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner;

public class Quersumme {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Quersumme program = new Quersumme();
    program.run();
  }

  /**/
  private void run() {
    Scanner input = new Scanner(System.in);
    String numbers = input.nextLine();
    int sum = 0;
    for (char c : numbers.toCharArray()) {
        sum += c - '0';
    }
    System.out.println(sum);
  }
}