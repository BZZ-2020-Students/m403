package wordfinder;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinderClient {
    private static final int AMOUNTTHREADS = 2;

    WordFinderThread[] finderThreads = new WordFinderThread[AMOUNTTHREADS];
    WordFinderGUI gui = new WordFinderGUI();
    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<Integer> foundPos = new ArrayList<>();
    String word = "lorem";

    public static void main(String[] args) {
        new WordFinderClient().run();
    }

    private void run() {
        getFileInput();
        initThreads();
        while (finderThreads[0].getThread().isAlive() || finderThreads[1].getThread().isAlive());
//        boolean done = false;
//        while (!done) {
//            for (WordFinderThread wft : finderThreads) {
//                if (wft.getThread().isInterrupted())
//                    done = true;
//            }
//        }
        System.out.println("after interrupt");
        printPositions();
    }

    private void printPositions() {
        for (Integer i : foundPos) {
            System.out.print(i + "; ");
        }
    }

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
                String[] ss = sc.nextLine().split(" ");
                for (String s : ss) {
                    wordList.add(s);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initThreads() {
        // Thread 1
        if (wordList.size() % 2 != 0)
            wordList.add("_");
        ArrayList<String> singleThreadWords = new ArrayList<>();
        for (int i = 0; i < wordList.size() / 2; i++)
            singleThreadWords.add(wordList.get(i));
        finderThreads[0] = new WordFinderThread("finderThread0", 0, singleThreadWords, word, this);

        singleThreadWords.clear();

        // Thread 2
        for (int i = 0; i < wordList.size() / 2; i++)
            singleThreadWords.add(wordList.get(i + (wordList.size() / 2) - 1));
        finderThreads[1] = new WordFinderThread("finderThread1", wordList.size() / 2, singleThreadWords, word, this);

        for (WordFinderThread finderThread : finderThreads) {
            finderThread.start();
        }
    }

    public void getPositions(ArrayList<Integer> array) {
        for (Integer i : array) {
            foundPos.add(i);
        }

//        boolean[] threadsDone = {false, false};
//        while (!threadsDone[0] && !threadsDone[1]) {
//            for (int i = 0; i < 2; i++) {
//                if (finderThreads[i].isDone() && !threadsDone[i]) {
//                    for (Integer j : finderThreads[i].getWordPositions())
//                        foundPos.add(j);
//                    threadsDone[i] = true;
//                }
//            }
//        }
    }
}
