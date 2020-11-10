/* M403
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner; //Imports the Scanner (class)

public class Wort {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Wort program = new Wort();
    program.run();
  }

  /* Takes an input and counts it's chars*/
  private void run() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a word: ");
    String word = sc.nextLine();
    int letterCount = 0;
    for (int i = 0; i <= word.length()-1 ; i++) {
      letterCount++;
    }
    System.out.println(letterCount);
  }
}
