/**
* Schachaufgabe
*
* @author Phillip Jerebic
* @since 2020-11-17
* @version 1.0
*/
import java.util.Scanner;

public class Schachturnier {
  /**
  * starts the execution
  *
  * @param args
  *            command line arguments
  */
  public static void main(String[] args) {
    Schachturnier st = new Schachturnier();
    st.run();
  }

  private void run()
  {
    Scanner scanner = new Scanner(System.in);
    int weiter;

    do{
        float punkte1 = 0;
        float punkte2 = 0;
        String sieger;
        float partie = 0;



        do{
          System.out.println("Anzahl Punkte Spieler 1: " + punkte1);
          System.out.println("Anzahl Punkte Spieler 2: " + punkte2);
          System.out.println("Anzahl Partien: " + partie);
          partie++;
          System.out.print("\n");

          System.out.println("Zahl Spieler 1: ");
          int zahlspeins = scanner.nextInt();

          System.out.println("Zahl Spieler 2: ");
          int zahlspzwei = scanner.nextInt();

        if(zahlspeins > zahlspzwei)
        {
          System.out.println("Spieler 1 hat gewonnen!!");
          punkte1++;
        }
        else if(zahlspzwei > zahlspeins)
        {
          System.out.println("Spieler 2 hat gewonnen!!");
          punkte2++;
        }
        else if(zahlspzwei == zahlspeins)
        {
          System.out.println("Unentschieden!!");
          punkte1 += 0.5;
          punkte2 += 0.5;
        }
        if(punkte1 > punkte2)
        {
          System.out.println("\nSpieler 1 hat gewonnen!!!\n§");
        }
        else if(punkte1 < punkte2)
        {
          System.out.println("\nSpieler 2 hat gewonnen!!!\n");
        }
      }while(punkte1 < 5 || punkte2 < 5);

      System.out.println("Möchten Sie nochmal spielen? Nochmal[1] Beenden[0]");
      weiter = scanner.nextInt();

    }while(weiter == 1);

    System.out.println("Auf Wiedersehen!!!");


  }
}
