package soccerManager;

import java.text.NumberFormat;
import java.util.Scanner;

public class Test {

        static final NumberFormat outFormat = NumberFormat.getInstance();

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int anzEingegeben = 0;
            double total = 0.0D;
            double schnitt = 0.0D;
            outFormat.setMinimumFractionDigits(1);
            outFormat.setMaximumFractionDigits(2);
            System.out.print("Anzahl Noten >");

            int anzNoten;
            for(anzNoten = Integer.parseInt(in.nextLine()); anzEingegeben < anzNoten; ++anzEingegeben) {
                System.out.print("Note >");
                double note = Double.parseDouble(in.nextLine());
                total += note;
            }

            schnitt = total / (double)anzNoten;
            System.out.print("Notenschnitt = " + outFormat.format(schnitt));
        }
}
