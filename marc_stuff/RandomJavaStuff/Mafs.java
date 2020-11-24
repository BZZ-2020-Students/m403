/* M403
*
*@author Marc Andri Fuchs
*@since 2020-11-10
*@version 0.1
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Mafs {

  public static Scanner sc;

  public static ArrayList<String> circ;
  public static ArrayList<String> sq;
  public static ArrayList<String> rad;
  public static ArrayList<String> to;
  public static ArrayList<String> dia;

  public static void main(String[] args) {
      Mafs program = new Mafs();

      sc = new Scanner(System.in);

      circ = new ArrayList<String>();
      sq = new ArrayList<String>();
      rad = new ArrayList<String>();
      to = new ArrayList<String>();
      dia = new ArrayList<String>();

      appendAliases();

      program.run();

  }

  private static void appendAliases() {
    circ.add("circumference");
    circ.add("circ");
    circ.add("umfang");

    sq.add("square");
    sq.add("sq");
    sq.add("quadrat");

    rad.add("radius");
    rad.add("rad");

    to.add("to");
    to.add("zu");

    dia.add("diameter");
    dia.add("dia");
    dia.add("durchmesser");
  }

  /**/
  private void run() {
      System.out.println("What do you want to calculate?");
      String input = sc.nextLine();

      if(input.split(" ")[0].equalsIgnoreCase("help")) {
        help();
      }

      else if (input.split(" ").length != 3) {
        System.out.println("Your input needs to contain 3 arguments!");
      }

      String[] args = input.split(" ");


      if (circ.contains(args[0].toLowerCase())) {
          if (to.contains(args[1].toLowerCase())) {
              if(rad.contains(args[2].toLowerCase())) {
                  circToRad();
              }

              else if (sq.contains(args[2].toLowerCase())) {
                circToSQ();
              }

              else if (dia.contains(args[2].toLowerCase())) {
                circToDia();
              }
          }
      }
  }

  private void circToRad() {
      System.out.println("Enter your circumference and it's unit:");
      String circWithUnitRad = sc.nextLine();

      if (circWithUnitRad.split(" ").length != 2) {
        System.out.println("Your input needs to contain 2 arguments!");
        return;
      }

      String[] circCalcRad = circWithUnitRad.split(" ");
      double circValRad = Double.parseDouble(circCalcRad[0]);
      double circToRadResRad = circValRad / Math.PI / 2;
      System.out.println("Your radius is: " + circToRadResRad + " " + circCalcRad[1]);
  }

  private void circToSQ() {
    System.out.println("Enter your circumference and it's unit:");
    String circWithUnitSQ = sc.nextLine();

    if (circWithUnitSQ.split(" ").length != 2) {
      System.out.println("Your input needs to contain 2 arguments!");
      return;
    }

    String[] circCalcSQ = circWithUnitSQ.split(" ");
    double circValSQ = Double.parseDouble(circCalcSQ[0]);
    double circToSQRes = circValSQ / 4;
    System.out.println("Your radius is: " + circToSQRes + " " + circCalcSQ[1]);
  }

  private void circToDia() {
    System.out.println("Enter your circumference and it's unit:");
    String circWithUnitDia = sc.nextLine();

    if (circWithUnitDia.split(" ").length != 2) {
      System.out.println("Your input needs to contain 2 arguments!");
      return;
    }

    String[] circCalcDia = circWithUnitDia.split(" ");
    double circValDia = Double.parseDouble(circCalcDia[0]);
    double circToDiaRes = circValDia / Math.PI;
    System.out.println("Your radius is: " + circToDiaRes + " " + circCalcDia[1]);
  }

  private void help() {
    System.out.println("You have to enter 3 arguments:");
    System.out.println("Argument 1 can be: " + "Circumference: " + circ.toString());
    System.out.println("Argument 2 can be: " + "To: " + to.toString());
    System.out.println("Argument 3 can be: " + "Square: " + sq.toString());
    System.out.println("                   " + "Diameter: " + dia.toString());
    System.out.println("                   " + "Radius: " + rad.toString());
    run();
  }


}
