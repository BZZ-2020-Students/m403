package wordfinder;

import java.util.ArrayList;

public class WordFinderThread implements Runnable {
    private Thread wordFinder;
    private final String threadName;
    private String word;
    private int startPos;
    private ArrayList<String> wordList;
    private ArrayList<Integer> foundPositions = new ArrayList<>();
    private WordFinderClient client;

    public WordFinderThread(String threadName, int startPos, ArrayList<String> wordList, String word, WordFinderClient client) {
        this.threadName = threadName;
        this.startPos = startPos;
        this.wordList = wordList;
        this.word = word;
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Thread running " + threadName);
        findWordPositions();
        System.out.println("before interrupt");
        wordFinder.interrupt();
    }

    public Thread getThread() {
        return wordFinder;
    }

    public void start() {
        System.out.println("THREAD " + threadName + " STARTED");
        if (wordFinder == null) {
            wordFinder = new Thread(this, threadName);
            wordFinder.start();
        }
    }

    public void findWordPositions() {
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (s.equalsIgnoreCase(word))
                foundPositions.add(i + startPos);
        }
        client.getPositions(foundPositions);

    }
}