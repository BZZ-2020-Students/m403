/**
* Hasen und Hühner
*
* @author Phillip Jerebic
* @since 2020-11-17
* @version 1.0
*/
import java.util.Scanner;

public class hasenundhuener {
  /**
  * starts the execution
  *
  * @param args
  *            command line arguments
  */
  public static void main(String[] args) {
    hasenundhuener hu = new hasenundhuener();
    hu.run();
  }

  private void run()
  {
    Scanner scanner = new Scanner(System.in);
    int anzhuhn = 0;

    System.out.println("Anzahl Beine: ");
    int anzbeine = scanner.nextInt();
    if(anzbeine % 2 == 1)
    {
      System.out.println("Es kann keine ungerade Anzahl Beine geben!!\nVersuchen Sie es erneut: ");
      anzbeine = scanner.nextInt();
    }



    System.out.println("Anzahl Tiere: ");
    int anztiere = scanner.nextInt();
    if (anztiere > anzbeine/2) {
      System.out.println("Es kann nicht mehr Tiere wie Beine haben!!\nVersuchs nochmal: ");
      int anztiere = scanner.nextInt();
    }
    int anzhase = anztiere;



    do{

      anzbeine = anzhase * 4 + 2 * anzhuhn;

      if(anzhase >= anzhuhn)
      {
        anzhase--;
        anzhuhn++;
      }
    }while(anzhase >= anzhuhn);

    System.out.println("Anzahl Huehner: " + anzhase);
    System.out.println("Anzahl Hasen: " + anzhuhn);

  }
}
