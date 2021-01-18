package todolist;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<Entry> list = new ArrayList<>();

    public TodoList() {
    }

    public void remove(int index) {
        list.remove(index);
    }

    public void add(Entry entry) {
        list.add(entry);
    }
    
    public ArrayList<Entry> getList() {
        return list;
    }
}
