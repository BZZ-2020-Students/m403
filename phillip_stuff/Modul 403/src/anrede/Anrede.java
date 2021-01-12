package anrede;


import java.util.Scanner;

/**
 * Geschlecht eingeben und ausgabe bekommen
 *
 * @author Phillip Jerebic
 * @version 1.0
 * @since 1.12.2020
 */

public class Anrede {

    public static void main (String[] args) {
        Anrede an = new Anrede();

        an.run();


    }

    private void run()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println ("Willkommen beim Anrede Simulator");


        char geschlecht;

        do{
        System.out.println("Eingabe Geschlecht W/M/X: ");
        geschlecht = scanner.next().charAt(0);



                if (geschlecht == 'W') {
                    System.out.println("D: Sehr geehrte Frau");
                    System.out.println("F: Chère madame");
                    System.out.println("E: Dear Mrs.");
                } else if(geschlecht == 'M'){
                    System.out.println("D: Sehr geehrter Herr");
                    System.out.println("F: Cher monsieur");
                    System.out.println("E: Dear Mr.");
                }
                else if(geschlecht == 'X')
                {
                    System.out.println("Auf Wiedersehen!!! \n\nIn cooperation with Muetzilla-industries 2020");
                }
                else
                    {
                        System.out.println("Falsche Eingabe!!! Geben Sie eine richtige eingabe ein!!!");
                        //System.out.println("Isch doch ned Schwierig M,W,oder X zneh");
                    }
            }while(geschlecht != 'X');

    }
}
