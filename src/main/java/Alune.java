import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
//import java.util.regex;

public class Alune {
    public static void main(String[] args) {
        Interface.greet();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        List<Task> tasks = Database.getDatabase();

        while (running) {
            System.out.println("\n\nenter: ");
            if (!scanner.hasNextLine()) {
                Interface.noInput();
                break;
            }

            String input = scanner.nextLine().trim().toLowerCase();
            String firstWord = input.split(" ")[0];
            Commands command = Commands.fromString(firstWord);

            switch (command) {
                case LIST: {
                    Interface.listTasks(tasks);
                    break;
                }
                case BYE: {
                    Interface.farewell();
                    running = false;
                    break;
                }
                case MARK: {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(5).trim()) - 1;
                        if (taskNumber < 0 || taskNumber > tasks.size()) {
                            Interface.taskNotFound();
                        }

                        tasks.get(taskNumber).markDone();
                        Database.updateDatabase();
                        Interface.markedDone(tasks.get(taskNumber));
                        break;
                    } catch (NumberFormatException e) {
                        Interface.invalidInput();
                    }
                    break;
                }
                case UNMARK: {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                        if (taskNumber < 0 || taskNumber > tasks.size()) {
                            Interface.taskNotFound();
                            break;
                        }

                        tasks.get(taskNumber).markUndone();
                        Database.updateDatabase();
                        Interface.markedUndone(tasks.get(taskNumber));
                    } catch (NumberFormatException e) {
                        Interface.invalidInput();
                    }
                    break;
                }
                case TODO: {
                    if (input.length() <= 5) {
                        Interface.invalidInput();
                        break;
                    }

                    String desc = input.substring(5).trim();
                    Task task = new ToDoTask(desc);
                    tasks.add(task);
                    Database.updateDatabase();
                    Interface.taskAdded(task.getName(), tasks.size());
                    break;
                }
                case DEADLINE: {
                    int byIndex = input.indexOf(" /by");
                    if (byIndex == -1 || byIndex <= 9 || input.length() <= byIndex + 4) {
                        Interface.invalidInput();
                        break;
                    }
                    
                    String desc = Functions.getDeadlineDescription(input);
                    String deadlineStr = Functions.getDeadlineString(input);
                    LocalDateTime deadline = Functions.getDateTime(deadlineStr);
                    
                    if (deadline == null) {
                        Interface.invalidDateTime();
                        break;
                    }

                    Task task = new DeadlineTask(desc, deadline);
                    tasks.add(task);
                    Database.updateDatabase();
                    Interface.taskAdded(task.getName(), tasks.size());
                    break;
                }
                case EVENT: {
                    int fromIndex = input.indexOf(" /from");
                    int toIndex = input.indexOf(" /to", fromIndex + 1);
                    if (fromIndex == -1 || toIndex == -1 || fromIndex <= 5 ||
                            toIndex - (fromIndex + 6) <= 0 || input.length() <= toIndex + 4) {
                        Interface.invalidInput();
                        break;
                    }

                    String desc = Functions.getEventDescription(input);
                    String startStr = Functions.getEventString(input, true);
                    String endStr = Functions.getEventString(input, false);
                    LocalDateTime start = Functions.getDateTime(startStr);
                    LocalDateTime end = Functions.getDateTime(endStr);

                    if (start == null || end == null) {
                        Interface.invalidDateTime();
                        break;
                    }

                    Task task = new EventTask(desc, start, end);
                    tasks.add(task);
                    Database.updateDatabase();
                    Interface.taskAdded(task.getName(), tasks.size());
                    break;
                }
                case DELETE: {
                    try {
                        int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                        if (taskNumber < 0 || taskNumber >= tasks.size()) {
                            Interface.taskNotFound();
                            break;
                        }

                        Task task = tasks.remove(taskNumber);
                        Database.updateDatabase();
                        Interface.deletedTask(task, tasks.size());
                    } catch (NumberFormatException e) {
                        Interface.invalidInput();
                    }

                    break;
                }
                case UNKNOWN: {
                    Interface.invalidCommand();
                    break;
                }
            }
        }

        scanner.close();
    }
}
