package taschenrechner;

import java.util.ArrayList;
import java.util.Scanner;

public class Taschenrechner {
    private Scanner scanner = new Scanner(System.in);
    private double resultat;
    private ArrayList<Double> zwischenspeicher = new ArrayList<>();

    public Taschenrechner() {
        ausgabeundeinlesen();
    }

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

    private void zwischenspeichern(double resultat) {
        zwischenspeicher.add(resultat);
    }

    private double plus() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();


        return weiterrechnen(weiterrechnen, zahleins, '+');
    }

    private double minus() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();

        return weiterrechnen(weiterrechnen, zahleins, '-');
    }

    private double mal() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();

        return weiterrechnen(weiterrechnen, zahleins, '*');
    }

    private double durch() {
        System.out.println("Möchten Sie mit einem zwischengeschpeichertem Resultat rechnen?[Ja = 1,Nein = 0]");
        int weiterrechnen = scanner.nextInt();

        System.out.println("Geben Sie ihre erste Ziffern ein: ");
        double zahleins = scanner.nextDouble();

        return weiterrechnen(weiterrechnen, zahleins, '/');
    }

    private double weiterrechnen(double weiterrechnen, double zahleins, char operator) {

        if (weiterrechnen == 1) {
            System.out.println("Diese Zahlen sind im Zwischenspeicher gespeichert: ");
            for (int i = 0; i < zwischenspeicher.size(); i++) {
                System.out.println(i + 1 + ". " + zwischenspeicher.get(i));
            }
            System.out.println("Welches zwischengeschpeicherte Resultat möchten Sie benutzen? ");
            int j = scanner.nextInt();
            switch (operator) {
                case '*':
                    resultat = zwischenspeicher.get(j - 1) * zahleins;
                    break;
                case '/':
                    resultat = zwischenspeicher.get(j - 1) / zahleins;
                    break;
                case '-':
                    resultat = zwischenspeicher.get(j - 1) - zahleins;
                    break;
                case '+':
                    resultat = zwischenspeicher.get(j - 1) + zahleins;
                    break;
            }

        } else {
            System.out.println("Geben Sie ihre zweite Zahl ein: ");
            double zahlzwei = scanner.nextDouble();
            switch (operator) {
                case '*':
                    resultat = zahlzwei * zahleins;
                    break;
                case '/':
                    resultat = zahlzwei / zahleins;
                    break;
                case '-':
                    resultat = zahlzwei - zahleins;
                    break;
                case '+':
                    resultat = zahlzwei + zahleins;
                    break;
            }

        }

        return resultat;
    }

    public static void main(String[] args) {
        new Taschenrechner();
    }
}
