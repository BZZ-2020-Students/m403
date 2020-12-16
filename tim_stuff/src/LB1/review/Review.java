package review;   import java.util.Scanner;
/**
  * play a game of backgammon
  * @author  Andre Probst (pra)
  * @author  Marcel Suter (sum)
  * @date    2015-11-11
  * @version 1.0
*/

public class Review {
  static Scanner scanner;
  
  public Review() {
	  scanner = new Scanner(System.in);
  }
  
  public static void main(String[] args) {
    Review program = new Review();
	program.menu();
    System.out.println("Programm beendet");
  }
  
  private void menu() {
      String password = "";
    int Versuche = 1;
    char auswahl = '.';
    
    System.out.print("Bitte geben Sie Ihr Passwort ein > ");
    password = scanner.nextLine();
    while ((!password.equals("passWORT")) && Versuche < 3) { 
    System.out.println("Passwort ungültig!");
    Versuche ++;
    System.out.print("Bitte geben Sie Ihr Passwort erneut ein > ");
    password = scanner.nextLine();
    };
    if (password.equals("passWORT")) {
      while (auswahl != 'X' && auswahl != 'x') { 
        //Menü aufbauen
        System.out.println("\n \n \nPande-Mee");
        System.out.println("---------");
        System.out.println("");
        System.out.println("A) Erfassen der Erkrankungen");
        System.out.println("B) Bestellung Impfmittel");
        System.out.println("C) Verwaltung Bestand der Impfmittel");;
        System.out.println("X) Beenden");
        System.out.println("");
        System.out.print("Ihre Wahl > ");
        auswahl = scanner.next().charAt(0);
        if (auswahl == 'A' || auswahl == 'a') {
          erfassen();
        } else if (auswahl == 'B' || auswahl == 'b') {
          bestellung();
        } else if (auswahl == 'C' || auswahl == 'c'){
          verwaltung();
        } else if (auswahl != 'X' && auswahl != 'x'){
          System.out.println("Keine gültige Auswahl");
          System.out.println("");
        }
      }
    } 
  }
  
  /**
  * Erfassen der Erkrankungen
  */
  private void erfassen() {
    int krankeGestern = 0;
    int krankeHeute = 0;
    boolean pandemie = false;
    
    System.out.println("");
    System.out.println("Pande-Mee: Erfassen der Erkrankungen");
    System.out.println("------------------------------------");
    System.out.println("");
    
    /*System.out.print("Anzahl Erkrankungen gestern > ");
    krankeGestern = scanner.nextInt();  sum 20151111*/
    
    while ((pandemie == false) && (krankeHeute >= krankeGestern)) { 
      krankeGestern = krankeHeute;
      krankeHeute = -1;
      
      while (krankeHeute < 0) { 
        System.out.print("Anzahl Erkrankungen > ");
        if (scanner.hasNextInt()) {
          krankeHeute = scanner.nextInt();
        } else; {
          System.out.println("Bitte geben Sie eine korrekte Anzahl ein");
        }
      };
      if (krankeGestern != 0 && krankeHeute > (krankeGestern * 1.5)) {
        pandemie = true;
      }
    }  
    
    if (pandemie) {
      System.out.print("Pandemie-Alarm!");
    } else {
      System.out.print("Alles überstanden");
    }
  }
  
  /**
  * Erfassen der Impfstoff-Bestellungen
  */
  
  private void bestellung() {
    int vorrat = 0;
    int totalBestellt = 0;
    int quote = 0;
    int bestellt = 1;
    String kunde = "";
    int lieferbar = 0;
    int lieferbarRounded = 0;
    
    System.out.println("Pande-Mee: Bestellungen");
    System.out.println("-----------------------");
    System.out.println("");
    
    System.out.print("Aktueller Vorrat   > ");
    vorrat = scanner.nextInt();
    System.out.print("Total Bestellungen > ");
    totalBestellt = scanner.nextInt();
    quote = (int)(((double)vorrat / (double)totalBestellt) * 100);
    if (quote > 100); {
      quote = 100;
    }
    System.out.println("Lieferquote:         " + quote + "%");
    while (bestellt != 0) { 
      System.out.println("");
      System.out.print("Menge              > ");
      bestellt = scanner.nextInt();
      if (bestellt > 0) {
        kunde = "";
        while (kunde.equals("") ) { 
            kunde = scanner.nextLine();    
            System.out.print("Kunde              > ");
            kunde = scanner.nextLine();                                        
        }
        lieferbar = (int)((double)bestellt / 100 * (double)quote);
        lieferbarRounded = (int)(Math.rint((double) lieferbar / 10) * 10);
        System.out.println("Lieferung:           " + lieferbarRounded + " Dosen an " + kunde);
        vorrat = vorrat - lieferbarRounded;
      } else {
        System.out.println("Bitte geben Sie eine positive Menge an");
      }
    }
    System.out.println("");
    System.out.println("-------------------------------------");
    System.out.println("Neuer Vorrat:        " + vorrat + " Dosen");
  }
 
  
  
  /**
  * Stammdaten der Impfstoffe verwalten
  */
  private static void verwaltung() {
      System.out.print("Teilprogramm: verwaltung\n\n\n");
  }
}
