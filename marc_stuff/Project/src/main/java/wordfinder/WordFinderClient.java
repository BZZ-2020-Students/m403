package wordfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordFinderClient {
    private int amountThreads;
    private boolean showDebug;

    private ArrayList<WordFinderThread> finderThreads = new ArrayList<>(); // ArrayList of all threads
    private ArrayList<String> wordList = new ArrayList<>(); // ArrayList of all words in the text
    private ArrayList<Integer> foundPositions = new ArrayList<>(); // ArrayList of all found occurrences of the word
    private String word = "lorem"; // the word we are searching for
    private String filePath;

    public static void main(String[] args) {
        new WordFinderClient().run();
    }

    /**
     * starts all the methods
     */
    private void run() {
        getUserInput();
        getFileInput();
        initThreads();
        //wait for all threads to finish processing
        try {
            for (WordFinderThread thread : finderThreads)
                thread.join();
        } catch (InterruptedException e) {
            System.err.println("There was an error with joining all threads!");
            e.printStackTrace();
        }
        if (showDebug)
            System.out.println("DEBUG INFORMATION > All threads have joined!");

        getPositions();
        if (showDebug)
            System.out.println("DEBUG INFORMATION > List of all found positions : " + foundPositions);

        new WordFinderGUI(foundPositions);
    }

    /**
     * Reads through the file with the text and adds them to wordList
     */
    private void getFileInput() {
        File inputText = new File(filePath);
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
                wordList.addAll(Arrays.asList(ss));
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

    /**
     * Gets the user input about if he wants to see debug info, the amount of threads, the word we will search for
     */
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

        System.out.print("How many threads do you want to run ..................> ");
        while (!sc.hasNextInt()) {
            System.out.print("This is not a valid integer, please try again >");
        }
        this.amountThreads = sc.nextInt();
        sc.nextLine();

        System.out.print("What's the word you want the program to find .........> ");
        this.word = sc.nextLine();

        System.out.println("Enter the path to your text file, you want to use ..>");
        this.filePath = sc.nextLine();

        System.out.println("If you have prepared the text you want to search press a button to continue!");
        sc.nextLine();

        sc.close();
    }
}
