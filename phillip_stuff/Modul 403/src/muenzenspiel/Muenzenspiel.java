package muenzenspiel;


import java.util.Scanner;

public class Muenzenspiel {
    public static void main (String[] args) {
        Muenzenspiel ms = new Muenzenspiel();

        System.out.println("Willkommen zum Münzenspiel");
        ms.run();
        }

    private void run() {

        Scanner scanner = new Scanner(System.in);

        int anzmuenzen = 0;
        int aktuellerSpieler = 1;
        int gezogenemuenzen = 0;

        /* generate random number of coins
           between 10 and 30 */
        anzmuenzen = (int)(Math.random() * 20 + 10);

        System.out.println("Anzahl Muenzen: " + anzmuenzen);

        while(anzmuenzen > 0)
        {
            System.out.println("Aktuelle Muenzen auf dem Tisch: " + anzmuenzen);
            System.out.println("Spieler " + aktuellerSpieler + " nimm 1-3 Muenzen");
            gezogenemuenzen = scanner.nextInt();

            if(gezogenemuenzen < 1)
            {
                System.out.println("Du musst mindestens 1 Münze nehmen");
            }
            else if(gezogenemuenzen > 3)
            {
                System.out.println("Du kannst hoechstens 3 Muenzen nehmen");
            }
            else
            {
                anzmuenzen = anzmuenzen - gezogenemuenzen;
            }
            aktuellerSpieler = 3 - aktuellerSpieler;
        }
        System.out.println("Spieler " + aktuellerSpieler + " hat verloren!!");
    }
}
