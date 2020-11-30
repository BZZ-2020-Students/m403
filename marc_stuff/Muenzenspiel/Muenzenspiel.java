/* M403
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

public class Muenzenspiel {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Muenzenspiel program = new Muenzenspiel();
    System.out.println("Gud Ebening!\n\n");
    program.run();
    System.out.println("Gud Bye!");
  }

  /**/
  private void run() {
    int coinsAmount = (int)Math.random() * 20 + 10;
    System.out.println(coinsAmount);


  }
}
