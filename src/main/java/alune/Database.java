package alune;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import alune.tasks.Task;
import alune.tasks.TaskList;

/**
 * This class stores the task data across program uses.
 * 
 * @author nghnaomi
 */

public class Database {
    private final String path;

    public Database(String filePath) {
        this.path = filePath;
    }

    /**
     * Updates the TaskList in the database for future reference.
     * 
     * @param tasks Latest version of the TaskList.
     */
    public void update(TaskList tasks) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(tasks.getTasks());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the existing TaskList or creates a new one for future reference.
     * 
     * @return Existing or newly created TaskList.
     */
    @SuppressWarnings("unchecked")
    public List<Task> load() {
        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
