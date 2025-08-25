package alune.tasks;
import java.io.Serializable;

/** This class is a parent class of the different tasks.
 *  @author nghnaomi */

public class Task implements Serializable {
    protected boolean done = false;
    protected String name;

    public Task(String name) {
        this.name = name;
    }

    public void markDone() {
        this.done = true;
    }

    public void markUndone() {
        this.done = false;
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