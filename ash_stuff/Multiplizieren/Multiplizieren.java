/* M403 1b
*
*@author Alyssa Heimlicher
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner; //Imports the Scanner (class)

public class Multiplizieren {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Multiplizieren program = new Multiplizieren();
    program.run();
  }

  /* prints out Hello Universe*/
  private void run() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an Integer: ");
    int x = Integer.parseInt(sc.nextLine());
    System.out.println(x * 23);
  }
}