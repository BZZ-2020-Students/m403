package taschenrechner;

import java.util.ArrayList;
import java.util.Scanner;

public class Taschenrechner {
    private Scanner scanner = new Scanner(System.in); //Scanner um Konsoleneingaben einzulesen
    private double resultat; // Das Resultat der rechnungen
    private ArrayList<Double> zwischenspeicher = new ArrayList<>(); // ArrayList für alle zwischengespeicherten Zahlen

    /**
     * Konstruktor
     */
    public Taschenrechner() {
        ausgabeundeinlesen();
    }

    /**
     * Diese Methode gibt das Resultat aus und fragt den User ab wie er rechnen möchte und ob er das Resultat
     * zwischenspeichern will.
     */
    private void ausgabeundeinlesen() {
        int weiterfahren;
        do {
            boolean korrektesformelzeichen = true;
            System.out.println("Taschenrechner");
            System.out.println("--------------");
            System.out.println();
            do {
                System.out.println("Wie möchten Sie rechnen?[+,-,*,/]");
                String formelzeichen = scanner.nextLine();
                if (formelzeichen.equals("+")) {
                    plus();
                } else if (formelzeichen.equals("-")) {
                    minus();
                } else if (formelzeichen.equals("*")) {
                    mal();
                } else if (formelzeichen.equals("/")) {
                    durch();
                } else {
                    System.out.println("Kein korrektes Formelzeichen!!!");
                    korrektesformelzeichen = false;
                }
            } while (!korrektesformelzeichen);


            System.out.println(resultat);
            System.out.println("Möchten Sie dieses Resultat zwischenspeichern? [Ja = 1, Nein = 0]");
            int zwischenspeichern = scanner.nextInt();
            scanner.nextLine();
            if (zwischenspeichern == 1) {
                zwischenspeichern(resultat);
            }
            System.out.println("Möchten Sie nochmal rechnen? [Ja = 1, Nein = 0]");
            weiterfahren = scanner.nextInt();
            scanner.nextLine();
        } while (weiterfahren == 1);
        System.out.println("Auf Wiedersehen!!");
    }

    /**
     * @param resultat wird in ArrayList zwischenspeicher gespeichert
     */
    private void zwischenspeichern(double resultat) {
        zwischenspeicher.add(resultat);
    }

    /**
     * Fragt den nutzer nach einer Zahl ab und addiert diese
     *
     * @return Resultat der Addition
     */
    private double plus() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();


        return weiterrechnen(weiterrechnen, zahleins, '+');
    }

    /**
     * Fragt den nutzer nach einer Zahl ab und subtrahiert diese
     *
     * @return Resultat der Subtraktion
     */
    private double minus() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();

        return weiterrechnen(weiterrechnen, zahleins, '-');
    }

    /**
     * Fragt den nutzer nach einer Zahl ab und multipliziert diese
     *
     * @return Resultat der Multiplikation
     */
    private double mal() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();

        return weiterrechnen(weiterrechnen, zahleins, '*');
    }

    /**
     * Fragt den nutzer nach einer Zahl ab und dividiert diese
     *
     * @return Resultat der Division
     */
    private double durch() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();

        return weiterrechnen(weiterrechnen, zahleins, '/');
    }

    /**
     * @param weiterrechnen
     * @param zahleins      Die erste Zahl die eingegeben wurde
     * @param operator      der Oparator, welcher verwendet werden soll
     * @return Das Resultat der Rechnung
     */
    private double weiterrechnen(double weiterrechnen, double zahleins, char operator) {

        if (weiterrechnen == 1) {
            System.out.println("Diese Zahlen sind im Zwischenspeicher gespeichert: ");
            for (int i = 0; i < zwischenspeicher.size(); i++) {
                System.out.println(i + 1 + ". " + zwischenspeicher.get(i));
            }
            System.out.println("Welches zwischengeschpeicherte Resultat möchten Sie benutzen? ");
            int j = scanner.nextInt();
            switch (operator) {
                case '*' -> resultat = zwischenspeicher.get(j - 1) * zahleins;
                case '/' -> resultat = zwischenspeicher.get(j - 1) / zahleins;
                case '-' -> resultat = zwischenspeicher.get(j - 1) - zahleins;
                case '+' -> resultat = zwischenspeicher.get(j - 1) + zahleins;
            }

        } else {
            System.out.println("Geben Sie ihre zweite Zahl ein: ");
            double zahlzwei = scanner.nextDouble();
            switch (operator) {
                case '*' -> resultat = zahlzwei * zahleins;
                case '/' -> resultat = zahlzwei / zahleins;
                case '-' -> resultat = zahlzwei - zahleins;
                case '+' -> resultat = zahlzwei + zahleins;
            }

        }

        return resultat;
    }

    /**
     * Startet die Exekution des Programmes
     *
     * @param args Kommandozeilen Argumente
     */
    public static void main(String[] args) {
        new Taschenrechner();
    }
}
