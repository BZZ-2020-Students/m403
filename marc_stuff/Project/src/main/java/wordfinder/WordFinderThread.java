package wordfinder;

import java.util.ArrayList;

/**
 * @author Marc-Andri Fuchs
 * @version 1.0
 */

public class WordFinderThread extends Thread {
    private final String threadName;
    private final boolean showDebug;
    private final String word;
    private final int startPos;
    private final int endPos;
    private final ArrayList<String> wordList;
    private final ArrayList<Integer> foundPositions = new ArrayList<>();

    /**
     * @param threadName is the name of the thread
     * @param startPos the position the stread starts searching for this word
     * @param wordList the list of all words
     * @param word the word we are searching for
     */
    public WordFinderThread(String threadName, int startPos, int endPos, ArrayList<String> wordList, String word, boolean showDebug) {
        this.threadName = threadName;
        this.startPos = startPos;
        this.endPos = endPos;
        this.wordList = wordList;
        this.word = word;
        this.showDebug = showDebug;
    }

    /**
     * This method gets run as soon as we create the thread
     */
    @Override
    public void run() {
        displayDebugInformation("DEBUG INFORMATION > Thread running : '" + threadName + "', startPos : " + startPos + ", endPos : " + endPos);
        findWordPositions();
    }

    /**
     * finds all the occurrences of the word in the list of all words
     */
    public void findWordPositions() {
        for (int i = startPos; i < endPos; i++) {
            String s = wordList.get(i);
            if (s.equalsIgnoreCase(word))
                foundPositions.add(i);
        }
        displayDebugInformation("DEBUG INFORMATION > " + threadName + " has found all occurrences of the word!");
    }

    /**
     * Shows the user debug information if he wants to see it
     * @param debugInput The text to show as Debug info
     */
    private void displayDebugInformation(String debugInput) {
        if (showDebug)
            System.out.println("DEBUG INFORMATION > " + debugInput);
    }

    /**
     * @return returns all found occurrences
     */
    public ArrayList<Integer> getFoundPos() {
        return foundPositions;
    }
}