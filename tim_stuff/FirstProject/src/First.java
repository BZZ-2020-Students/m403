import java.util.Scanner;
 
/**
 * calculate the number of rabbits and chickens
 * 
 * @author Marcel Suter
 * @since 2017-10-02
 * @version 1.0
 */
public class First {
 
    Scanner scanner;
 
    /**
     * constructor
     */
    public First() {
        scanner = new Scanner(System.in);
    }
 
    /**
     * starts the execution
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        First program = new First();
 
        System.out.println("Willkommen");
        program.calculate();
        System.out.println("Bye Bye");
    }
 
    /**
     * calculates the numbers
     */
    private void calculate() {
        int animals;
        int legs;
        int rabbit;
        int chicken;
 
        System.out.print("Anzahl Tiere >");
        animals = scanner.nextInt();
 
        System.out.print("Anzahl Beine >");
        legs = scanner.nextInt();
 
        rabbit = animals;
        chicken = 0;
 
        while ((rabbit * 4 + chicken * 2) > legs) {
            rabbit = rabbit - 1;
            chicken = chicken + 1;
        }
 
        System.out.println("Es sind " + rabbit + " Hasen und " + chicken + " Huehner");
 
    }
}