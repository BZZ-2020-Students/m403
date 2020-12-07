/* 
*
*@author Alyssa Heimlicher
*@since 2020-11-24
*@version 0.1
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Notenschnitt {
  /*
  * starts the execution
  * @param args
  */
  public static void main(String[] args) {
    Notenschnitt program = new Notenschnitt();
    program.run();
  }

  private void run() {

    int totalMarks = 0;
    int amountOfMarks = 0;
    double total = 0;

    ArrayList<Double> marks = new ArrayList<Double>();

    Scanner sc = new Scanner(System.in);

    seperator();
    System.out.println("Wie viele Noten hast du?");
    totalMarks = Integer.parseInt(sc.nextLine());

    for (int i = amountOfMarks; i < totalMarks; i++) {
      seperator();
      System.out.println("Du hast schon " + amountOfMarks + " von " + totalMarks + " eingegeben!");
      System.out.println("Geben Sie eine Note zwischen 1 und 6 ein!");
      double currentMark = sc.nextDouble();

      if(currentMark < 1 || currentMark > 6) {
        System.out.println("NO!");
      }
      else{
        total += currentMark;
        marks.add(currentMark);
        amountOfMarks++;
      }
    }

    System.out.println("Deine Noten sind:");
    for(int a = 0; a < marks.size(); a++) {
      int marknumber = a+1;
      System.out.println("Note " + marknumber + ":........" + marks.get(a));
    }
    seperator();
    System.out.println("Ihr Durchschnit ist: " + total / totalMarks);
    seperator();
  }

  private void seperator() {
    System.out.println("\n");
    System.out.print("+");
    for(int i = 0; i < 50; i++) {
      System.out.print("-");
    }
    System.out.print("+");
    System.out.println("\n");
  }
}