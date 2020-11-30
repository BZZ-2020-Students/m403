
public class Helloworld {
    public static void main(String[] args) {
        Helloworld program = new Helloworld(); // program = Name of the object, name it whatever you want
        program.run();
    }

    public void run() {
        System.out.println("Hello World\n");

        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World " + (i + 1));
        }
    }
}
