/**
* print "Hello Universe"
*
* @author Phillip Jerebic
* @since 2020-11-10
* @version 1.0
*/
import java.util.Scanner;

public class Universe {
  /**
  * starts the execution
  *
  * @param args
  *            command line arguments
  */
  public static void main(String[] args) {
    Universe program = new Universe();
    program.run();
  }

  /**
  * runs the program
  */
  private void run() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Wie vielmal soll Hello Universe augegeben werden: ");
    int anzahl = scanner.nextInt();


    for(int i=0; i <= anzahl; i++)
  		{
  		  System.out.println("Hello Universe ");
  		}
  }
}
