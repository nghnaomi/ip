package alune;

import java.time.LocalDateTime;

import alune.tasks.DeadlineTask;
import alune.tasks.EventTask;
import alune.tasks.Task;
import alune.tasks.TaskList;
import alune.tasks.ToDoTask;
import alune.ui.UI;
import alune.utils.Parser;

/**
 * This standard class handles inputs to the main program Alune.
 * 
 * @author nghnaomi
 */

public class Alune {
    private final Database database;
    private final TaskList tasks;
    private final UI ui;

    public Alune(String filePath) {
        ui = new UI();
        database = new Database(filePath);
        tasks = new TaskList(database.load());
    }

    /**
     * Returns the chatbot's response to the given command, including a default for
     * unknown commands.
     * 
     * @param input User's message to the chatbot.
     * @return String response to user's command.
     */
    public String getResponse(String input) {
        String firstWord = input.split(" ")[0];
        Commands command = Commands.fromString(firstWord);

        switch (command) {
            case HI: {
                return ui.greet();
            }
            case LIST: {
                return ui.listTasks(tasks);
            }
            case BYE: {
                return ui.farewell();
            }
            case MARK: {
                try {
                    int index = Parser.parseMarkCommand(input);
                    tasks.mark(index);
                    database.update(tasks);
                    return ui.markedDone(tasks.getTask(index));
                } catch (NumberFormatException e) {
                    return ui.invalidInput();
                } catch (IndexOutOfBoundsException e) {
                    return ui.taskNotFound();
                }
            }
            case UNMARK: {
                try {
                    int index = Parser.parseUnmarkCommand(input);
                    tasks.unmark(index);
                    database.update(tasks);
                    return ui.markedUndone(tasks.getTask(index));
                } catch (NumberFormatException e) {
                    return ui.invalidInput();
                } catch (IndexOutOfBoundsException e) {
                    return ui.taskNotFound();
                }
            }
            case TODO: {
                if (input.length() <= 5) {
                    return (ui.invalidInput());
                }

                String desc = input.substring(5).trim();
                Task task = new ToDoTask(desc);
                tasks.addTask(task);
                database.update(tasks);
                return ui.taskAdded(task.getName(), tasks.size());
            }
            case DEADLINE: {
                int byIndex = input.indexOf(" /by");
                if (byIndex == -1 || byIndex <= 9 || input.length() <= byIndex + 4) {
                    return ui.invalidInput();
                }

                String desc = Parser.getDeadlineDescription(input);
                String deadlineStr = Parser.getDeadlineString(input);
                LocalDateTime deadline = Parser.getDateTime(deadlineStr);

                if (deadline == null) {
                    return ui.invalidDateTime();
                }

                Task task = new DeadlineTask(desc, deadline);
                tasks.addTask(task);
                database.update(tasks);
                return ui.taskAdded(task.getName(), tasks.size());
            }
            case EVENT: {
                int fromIndex = input.indexOf(" /from");
                int toIndex = input.indexOf(" /to", fromIndex + 1);
                if (fromIndex == -1 || toIndex == -1 || fromIndex <= 5 ||
                        toIndex - (fromIndex + 6) <= 0 || input.length() <= toIndex + 4) {
                    return ui.invalidInput();
                }

                String desc = Parser.getEventDescription(input);
                String startStr = Parser.getEventString(input, true);
                String endStr = Parser.getEventString(input, false);
                LocalDateTime start = Parser.getDateTime(startStr);
                LocalDateTime end = Parser.getDateTime(endStr);

                if (start == null || end == null) {
                    return ui.invalidDateTime();
                }

                Task task = new EventTask(desc, start, end);
                tasks.addTask(task);
                database.update(tasks);
                return ui.taskAdded(task.getName(), tasks.size());
            }
            case DELETE: {
                try {
                    int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                    if (taskNumber < 0 || taskNumber >= tasks.size()) {
                        return ui.taskNotFound();
                    }

                    Task task = tasks.removeTask(taskNumber);
                    database.update(tasks);
                    return ui.deletedTask(task, tasks.size());
                } catch (NumberFormatException e) {
                    return ui.invalidInput();
                }
            }
            case CLEAR: {
                int total = tasks.size();
                while (!tasks.isEmpty()) {
                    tasks.removeTask(0);
                }
                database.update(tasks);
                return ui.clearTasks(total);
            }
            case FIND: {
                String toSearch = Parser.parseFindCommand(input);
                if (toSearch.equals("")) {
                    return ui.invalidInput();
                } else {
                    return ui.listFilteredTasks(tasks, toSearch);
                }
            }
            case UNKNOWN: {
                return ui.invalidCommand();
            }
        }

        return "";
    }
}
