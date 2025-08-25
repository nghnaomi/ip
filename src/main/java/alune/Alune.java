package alune;

import java.time.LocalDateTime;
import java.util.Scanner;

import alune.tasks.DeadlineTask;
import alune.tasks.EventTask;
import alune.tasks.Task;
import alune.tasks.TaskList;
import alune.tasks.ToDoTask;
import alune.ui.UI;
import alune.utils.Parser;

/** This standard class handles inputs to the main program Alune.
 *  @author nghnaomi */

public class Alune {
    private final Database database;
    private final TaskList tasks;
    private final UI ui;

    public Alune(String filePath) {
        ui = new UI();
        database = new Database(filePath);
        tasks = new TaskList(database.load());
    }

    public void run() {
        ui.greet();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n\nenter: ");

            if (!scanner.hasNextLine()) {
                ui.noInput();
                break;
            }

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                ui.invalidInput();
                continue;
            }

            String firstWord = input.split(" ")[0];
            Commands command = Commands.fromString(firstWord);

            switch (command) {
                case LIST: {
                    ui.listTasks(tasks);
                    break;
                }
                case BYE: {
                    ui.farewell();
                    running = false;
                    break;
                }
                case MARK: {
                    try {
                        int index = Parser.parseMarkCommand(input);
                        tasks.mark(index);
                        database.update(tasks);
                        ui.markedDone(tasks.getTask(index));
                    } catch (NumberFormatException e) {
                        ui.invalidInput();
                    } catch (IndexOutOfBoundsException e) {
                        ui.taskNotFound();
                    }
                    break;
                }
                case UNMARK: {
                    try {
                        int index = Parser.parseUnmarkCommand(input);
                        tasks.unmark(index);
                        database.update(tasks);
                        ui.markedUndone(tasks.getTask(index));
                    } catch (NumberFormatException e) {
                        ui.invalidInput();
                    } catch (IndexOutOfBoundsException e) {
                        ui.taskNotFound();
                    }
                    break;
                }
                case TODO: {
                    if (input.length() <= 5) {
                        ui.invalidInput();
                        break;
                    }

                    String desc = input.substring(5).trim();
                    Task task = new ToDoTask(desc);
                    tasks.addTask(task);
                    database.update(tasks);
                    ui.taskAdded(task.getName(), tasks.size());
                    break;
                }
                case DEADLINE: {
                    int byIndex = input.indexOf(" /by");
                    if (byIndex == -1 || byIndex <= 9 || input.length() <= byIndex + 4) {
                        ui.invalidInput();
                        break;
                    }

                    String desc = Parser.getDeadlineDescription(input);
                    String deadlineStr = Parser.getDeadlineString(input);
                    LocalDateTime deadline = Parser.getDateTime(deadlineStr);

                    if (deadline == null) {
                        ui.invalidDateTime();
                        break;
                    }

                    Task task = new DeadlineTask(desc, deadline);
                    tasks.addTask(task);
                    database.update(tasks);
                    ui.taskAdded(task.getName(), tasks.size());
                    break;
                }
                case EVENT: {
                    int fromIndex = input.indexOf(" /from");
                    int toIndex = input.indexOf(" /to", fromIndex + 1);
                    if (fromIndex == -1 || toIndex == -1 || fromIndex <= 5 ||
                            toIndex - (fromIndex + 6) <= 0 || input.length() <= toIndex + 4) {
                        ui.invalidInput();
                        break;
                    }

                    String desc = Parser.getEventDescription(input);
                    String startStr = Parser.getEventString(input, true);
                    String endStr = Parser.getEventString(input, false);
                    LocalDateTime start = Parser.getDateTime(startStr);
                    LocalDateTime end = Parser.getDateTime(endStr);

                    if (start == null || end == null) {
                        ui.invalidDateTime();
                        break;
                    }

                    Task task = new EventTask(desc, start, end);
                    tasks.addTask(task);
                    database.update(tasks);
                    ui.taskAdded(task.getName(), tasks.size());
                    break;
                }
                case DELETE: {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                        if (taskNumber < 0 || taskNumber >= tasks.size()) {
                            ui.taskNotFound();
                            break;
                        }

                        Task task = tasks.removeTask(taskNumber);
                        database.update(tasks);
                        ui.deletedTask(task, tasks.size());
                    } catch (NumberFormatException e) {
                        ui.invalidInput();
                    }

                    break;
                }
                case WIPE: {
                    int total = tasks.size();
                    while (!tasks.isEmpty()) {
                        tasks.removeTask(0);
                    }
                    database.update(tasks);
                    ui.wipedTasks(total);
                    break;
                }
                case UNKNOWN: {
                    ui.invalidCommand();
                    break;
                }
            }
        }

        scanner.close();
    }

    public static void main(String args[]) {
        new Alune("./data/record.txt").run();
    }
}
