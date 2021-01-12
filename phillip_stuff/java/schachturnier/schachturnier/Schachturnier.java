/**
* Schachaufgabe
*
* @author Phillip Jerebic
* @since 2020-11-17
* @version 1.0
*/
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
  float punkte1 = 0;
  float punkte2 = 0;
  String sieger;
  float partie = 0;
  int zahlsp1;
  int zahlsp2;

  do{
    System.out.println("Anzahl Punkte Spieler 1: " + punkte1);
    System.out.println("Anzahl Punkte Spieler 2: " + punkte2);
    System.out.println("Anzahl Partien: " + partie);
    partie++;

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
  else
  {
    System.out.print("Unentschieden!!");
    punkte1 = punkte1 + 0.5;
    punkte2 = punkte2 + 0.5;
  }
}while(punkte1 != 5 || punkte2 != 5);


}
