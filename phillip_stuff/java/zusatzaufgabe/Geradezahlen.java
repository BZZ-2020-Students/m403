/**
* Zusatzaufgabe
*
* @author Phillip Jerebic
* @since 2020-11-10
* @version 1-0
*/

public class Geradezahlen {
  /**
  * starts the execution
  *
  * @param args command line arguments
  */
  public static void main(String[] args) {
    Geradezahlen program = new  Geradezahlen();
    program.run();
  }

  /**
  * runs the program
  */
  private void run()
    {
      for(int i=0; i <= 200; i++)
      {
        if(i % 2 == 0)
        {
          System.out.print(i + "\n");
        }

      }
    }
  }
