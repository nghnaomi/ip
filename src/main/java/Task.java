import java.io.Serializable;

public class Task implements Serializable {
    protected boolean done = false;
    protected String name;

    public Task(String name) {
        this.name = name;
    }

    public void markDone() {
        this.done = true;
        return;
    }

    public void markUndone() {
        this.done = false;
        return;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.done
            ? "[X] " + this.name
            : "[ ] " + this.name;
    }

}