package todolist;

public class Entry {
    boolean status;
    int priority;
    String title;
    String desc;

    public Entry(String title, String desc, int priority) {
        status = false;
        this.title = title;
        this.desc = desc;
        this.priority = priority;
    }

    public boolean isCompleted() {
        return status;
    }

    public void setCompleted(boolean status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return status + ";" +
                priority + ";" +
                title + ";" +
                desc;
    }
}
