/* M403 1b
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner; //Imports the Scanner (class)
import java.util.ArrayList;
import java.util.List;

public class GeradeZahlen {


  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    GeradeZahlen program = new GeradeZahlen();
    program.run();
  }

  /* prints out Hello Universe*/
  private void run() {

    List<Integer> arr = new ArrayList<>();


    for (int i = 1; i >= 200; i++) {
      if (i % 2 == 0) {
        arr.add(i);
      }
    }

    System.out.println(arr);
  }
}
