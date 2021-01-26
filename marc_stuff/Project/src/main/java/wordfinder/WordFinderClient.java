package wordfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Marc-Andri Fuchs
 * @version 1.0
 * 
 * Takes a file as an input of words and searches the specifies word with multiple threads
 */

public class WordFinderClient {
    private int amountThreads;
    private boolean showDebug;

    private final ArrayList<WordFinderThread> finderThreads = new ArrayList<>(); // ArrayList of all threads
    private final ArrayList<String> wordList = new ArrayList<>(); // ArrayList of all words in the text
    private final ArrayList<Integer> foundPositions = new ArrayList<>(); // ArrayList of all found occurrences of the word
    private String word = "lorem"; // the word we are searching for
    private String filePath;
    private final StopWatch sw = new StopWatch();

    public static void main(String[] args) {
        new WordFinderClient().run();
    }

    /**
     * starts all the methods
     */
    private void run() {
        getUserInput();
        sw.start();
        getFileInput();
        if (amountThreads > wordList.size()) {
            try {
                throw new Exception("The amount of threads is bigger than the amount of words in the File!");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        initThreads();
        //wait for all threads to finish processing
        try {
            for (WordFinderThread thread : finderThreads)
                thread.join();
        } catch (InterruptedException e) {
            System.err.println("There was an error with joining all threads!");
            e.printStackTrace();
        }
        sw.stop();
        displayDebugInformation("All threads have joined!");

        getPositions();
        displayDebugInformation("List of all found positions : " + foundPositions);

        new WordFinderGUI(foundPositions);
        System.out.println("The program found the words in : " + sw);
    }

    /**
     * Reads through the file with the text and adds them to wordList
     */
    private void getFileInput() {
        File inputText = new File(filePath);
        try {
            Scanner sc = new Scanner(inputText);
            while (sc.hasNextLine()) {
                String[] ss = sc.nextLine().replaceAll(",", "").replaceAll("\\.", "").split("\\s");
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
        displayDebugInformation("All threads have been initialized!");
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
        int debugInput;
        do {
            System.out.print("Do you want to see debug information [0 = no, 1 = yes]> ");
            while (!sc.hasNextInt()) {
                System.out.print("This is not a valid answer, try again ............... > ");
                sc.next();
            }
            debugInput = sc.nextInt();
        } while (debugInput < 0 || debugInput > 1);

        switch (debugInput) {
            case 0 -> this.showDebug = false;
            case 1 -> this.showDebug = true;
        }

        do {
            System.out.println("You shouldn't use more threads than there are words in the file!");
            System.out.print("How many threads do you want to run ..................> ");
            while (!sc.hasNextInt()) {
                System.out.print("This is not a valid integer, please try again >");
            }
            this.amountThreads = sc.nextInt();
            sc.nextLine();
        } while (amountThreads < 1);

        System.out.print("What's the word you want the program to find .........> ");
        this.word = sc.nextLine();

        boolean exists;
        do {
            System.out.print("Enter the path to your text file, you want to use ..> ");
            this.filePath = sc.nextLine();
            File check = new File(filePath);
            if (!check.exists()) {
                exists = false;
                System.out.println("This file does not exit, please try again!");
            } else {
                exists = true;
            }
        } while (!exists);
        sc.close();
    }

    /**
     * Shows the user debug information if he wants to see it
     * @param debugInput The text to show as Debug info
     */
    public void displayDebugInformation(String debugInput) {
        if (showDebug)
            System.out.println("DEBUG INFORMATION > " + debugInput);
    }
}
