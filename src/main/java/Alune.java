import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alune {
    public static void main(String[] args) {
        Interface.greet();
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n\nenter: ");
            if (!scanner.hasNextLine()) {
                Interface.noInput();
                break;
            }

            String input = scanner.nextLine().trim().toLowerCase();
            String firstWord = input.split(" ")[0];
            Command command = Command.fromString(firstWord);

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
                    int taskNumber = Integer.parseInt(input.substring(5).trim()) - 1;
                    if (taskNumber < 0 || taskNumber > tasks.size()) {
                        Interface.taskNotFound();
                        break;
                    }

                    tasks.get(taskNumber).markDone();
                    Interface.markedDone(tasks.get(taskNumber));
                    break;
                }
                case UNMARK: {
                    int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                    if (taskNumber < 0 || taskNumber > tasks.size()) {
                        Interface.taskNotFound();
                        break;
                    }

                    tasks.get(taskNumber).markUndone();
                    Interface.markedUndone(tasks.get(taskNumber));
                    break;
                }
                case TODO: {
                    if (input.length() <= 5) {
                        Interface.invalidDescription();
                        break;
                    }

                    String desc = input.substring(5).trim();
                    tasks.add(new ToDoTask(desc));
                    Interface.taskAdded(desc, tasks.size());
                    break;
                }
                case DEADLINE: {
                    int byIndex = input.indexOf(" /by");
                    if (byIndex == -1 || byIndex <= 9 || input.length() <= byIndex + 4) {
                        Interface.invalidDescription();
                        break;
                    }

                    String desc = Helpers.getDeadlineDescription(input);
                    String deadline = Helpers.getDeadline(input);
                    tasks.add(new DeadlineTask(desc, deadline));
                    Interface.taskAdded(desc, tasks.size());
                    break;
                }
                case EVENT: {
                    int fromIndex = input.indexOf(" /from");
                    int toIndex = input.indexOf(" /to", fromIndex + 1);
                    if (fromIndex == -1 || toIndex == -1 || fromIndex <= 5 ||
                            toIndex - (fromIndex + 6) <= 0 || input.length() <= toIndex + 4) {
                        Interface.invalidDescription();
                        break;
                    }

                    String desc = Helpers.getEventDescription(input);
                    String start = Helpers.getEventTime(input, true);
                    String end = Helpers.getEventTime(input, false);
                    tasks.add(new EventTask(desc, start, end));
                    Interface.taskAdded(desc, tasks.size());
                    break;
                }
                case DELETE: {
                    int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                    if (taskNumber < 0 || taskNumber > tasks.size()) {
                        Interface.taskNotFound();
                        break;
                    }

                    Task task = tasks.remove(taskNumber);
                    Interface.deletedTask(task, tasks.size());
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
