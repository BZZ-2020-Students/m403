/**
* Multiplizieren
*
* @author Phillip Jerebic
* @since 2020-11-10
* @version 1-0
*/

public class Multiplizieren {
  /**
  * starts the execution
  *
  * @param args command line arguments
  */
  public static void main(String[] args) {
    Multiplizieren program = new  Multiplizieren();
    program.run();
  }

  /**
  * runs the program
  */
  private void run()
    {
      int zahl1 = 0;
      int resultat = 0;
        System.out.print("Geben Sie Ihre Zahl ein: ");
        System.in.scan("%d", zahl1);
          System.out.print(resultat + "\n");

    }
  }
