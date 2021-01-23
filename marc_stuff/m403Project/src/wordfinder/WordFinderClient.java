package wordfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinderClient {
    private int amountThreads;
    private boolean showDebug;

    ArrayList<WordFinderThread> finderThreads = new ArrayList<>(); // ArrayList of all threads
    ArrayList<String> wordList = new ArrayList<>(); // ArrayList of all words in the text
    ArrayList<Integer> foundPositions = new ArrayList<>(); // ArrayList of all found occurrences of the word
    String word = "lorem"; // the word we are searching for

    public static void main(String[] args) throws InterruptedException {
        new WordFinderClient().run();
    }

    /**
     * starts all the methods
     *
     * @throws InterruptedException because we are waiting for the threads to join
     */
    private void run() throws InterruptedException {
        getUserInput();
        getFileInput();
        initThreads();
        //wait for all threads to finish processing
        for (WordFinderThread thread : finderThreads)
            thread.join();
        if (showDebug)
            System.out.println("DEBUG INFORMATION > All threads have joined!");

        getPositions();
        if (showDebug)
            System.out.println("DEBUG INFORMATION > List of all found positions : " + foundPositions);

        WordFinderGUI gui = new WordFinderGUI(foundPositions);
    }

    /**
     * Reads through the file with the text and adds them to wordList
     */
    private void getFileInput() {
        File inputText = new File("input.txt");
        if (!inputText.exists()) {
            try {
                inputText.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner sc = new Scanner(inputText);
            while (sc.hasNextLine()) {
                String[] ss = sc.nextLine().replaceAll(",", " ").split("\\s");
                for (String s : ss)
                    wordList.add(s);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes all threads with the correct variables
     */
    private void initThreads() {
        int part = wordList.size() / amountThreads;
        for (int i = 0; i < amountThreads; i++) {
            finderThreads.add(new WordFinderThread("Thread" + i, part * i, part * (i + 1), wordList, word, showDebug));
            finderThreads.get(i).start();
        }
        if (showDebug)
            System.out.println("DEBUG INFORMATION > All threads have been initialized!");
    }

    /**
     * Gets the found positions of all threads and adds them to the ArrayList
     */
    public void getPositions() {
        for (WordFinderThread t : finderThreads)
            this.foundPositions.addAll(t.getFoundPos());
    }

    private void getUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want to see debug information [0 = no, 1 = yes]> ");
        while (!sc.hasNextInt()) {
            System.out.print("This is not a valid answer, try again ............... > ");
            sc.next();
        }
        int debugInput = sc.nextInt();
        switch (debugInput) {
            case 0:
                this.showDebug = false;
                break;
            case 1:
                this.showDebug = true;
                break;
        }

        /**
         * Gets the user input about if he wants to see debug info, the amount of threads, the word we will search for
         */
        System.out.print("How many threads do you want to run ..................> ");
        while (!sc.hasNextInt()) {
            System.out.print("This is not a valid integer, please try again >");
        }
        this.amountThreads = sc.nextInt();
        sc.nextLine();

        System.out.print("What's the word you want the program to find > ");
        this.word = sc.nextLine();

        System.out.println("Create a file called 'input.txt' in your working directory");
        System.out.println("Add the text you want in this file");
        System.out.println("If you have prepared the text you want to search press a button to continue!");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
