package todolist;

public class DemoTodoList {
    TodoList list = new TodoList();

    public static void main(String[] args) {
        new DemoTodoList().run();
    }

    private void run() {
        list.add(new Entry("Title", "This is a description", 1));
        printList();
    }

    private void printList() {
        int i = 0;
        for (Entry e : list.getList()) {
            System.out.format("%d \t %s \t %s \t priority : %d \t completed : %b", i, e.getTitle(), e.getDesc(), e.getPriority(), e.isCompleted());
            i++;
        }
    }
}
