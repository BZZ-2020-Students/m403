/* M403 1b
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

import java.util.Arrays;

public class GeradeZahlen {
  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    GeradeZahlen program = new GeradeZahlen();
    program.run();
  }

  /**/
  private void run() {
    int[] arr = {};
    for (int i = 1; i <= 200; i++) {
      if (i % 2 == 0) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = i;
        //System.out.println(i);
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
