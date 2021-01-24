/* Satisfying Text
*
*@author Marc Andri Fuchs
*@since 2020-12-01
*@version 0.1
*/

public class Satisfying {

  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Satisfying program = new Satisfying();
    program.run();
  }

  /**/
  private void run() {
    int space = 0;
    int space_after = 60;

      while(space <= 30) {
        for(int i = 0; i <= space; i++) {
          System.out.print(" ");
        }
        System.out.print("Satisfying");

        for(int i = 0; i <= space_after; i++) {
          System.out.print(".");
        }
        System.out.print("Satisfying\n");

        sleep();
        space++;
        space_after -= 2;
      }

      while (space >= 0) {
        for(int i = 0; i <= space; i++) {
          System.out.print(" ");
        }
        System.out.print("Satisfying");

        for(int i = 0; i <= space_after; i++) {
          System.out.print(".");
        }
        System.out.print("Satisfying\n");

        sleep();
        space_after += 2;
        space--;
      }
      run();
  }

  private void sleep() {
    try {
        Thread.sleep(10);
    } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
    }
  }
}
