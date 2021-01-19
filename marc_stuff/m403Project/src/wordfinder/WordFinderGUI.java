package wordfinder;

import javax.swing.*;

public class WordFinderGUI extends JFrame {
    public WordFinderGUI() {
        initComponents();
    }

    private void initComponents() {
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("WordFinder");
        setVisible(true);
    }
}
