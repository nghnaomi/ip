package alune.tasks;

import java.util.List;

public class TaskList {
    private int total;
    private final List<Task> list;

    public TaskList(List<Task> database) {
        this.total = database.size();
        this.list = database;
    }

    public void addTask(Task task) {
        list.add(task);
        total++;
    }

    public Task removeTask(int index) {
        Task task = list.remove(index);
        total--;
        return task;
    }

    public List<Task> getTasks() {
        return list;
    }

    public int size() {
        return total;
    }

    public Task getTask(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public void printTasks() {
        int num = 1;
        for (Task task : list) {
            System.out.println(num + ". " + task);
            num++;
        }
    }

    public void mark(int index) {
        list.get(index).markDone();
    }

    public void unmark(int index) {
        list.get(index).markUndone();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public TaskList searchList(String key) {
        List<Task> filtered = this.list.stream().filter(t -> t.getName().contains(key)).toList();
        return new TaskList(filtered);
    }
}