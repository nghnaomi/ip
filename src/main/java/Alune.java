import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alune {
    public static void main(String[] args) {
        String logo = "\n   _      _      _      _      _      _   \n"
                + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ \n"
                + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)\n"
                + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) \n"
                + "   _                                  _   \n"
                + " _( )_         _                    _( )_ \n"
                + "(_ o _)   __ _| |_   _ _ __   ___  (_ o _)\n"
                + " (_,_)   / _` | | | | | '_ \\ / _ \\  (_,_) \n"
                + "   _    | (_| | | |_| | | | |  __/    _   \n"
                + " _( )_   \\__,_|_|\\__,_|_| |_|\\___|  _( )_ \n"
                + "(_ o _)                            (_ o _)\n"
                + " (_,_)                              (_,_) \n"
                + "   _      _      _      _      _      _   \n"
                + " _( )_  _( )_  _( )_  _( )_  _( )_  _( )_ \n"
                + "(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)(_ o _)\n"
                + " (_,_)  (_,_)  (_,_)  (_,_)  (_,_)  (_,_) \n";

        System.out.println(logo + "\n\nhi i'm alune~ what can i do for you? (⸝⸝ᵕᴗᵕ⸝⸝)" +
                "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");

        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n\nenter: ");
            if (!scanner.hasNextLine()) {
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\nno more input. goodbye~ ヾ(＾∇＾)" +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n");
                break;
            }
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("list")) { // list
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\nyour tasks: ᕙ( •̀ ᗜ •́ )ᕗ");
                if (tasks.isEmpty()) {
                    System.out.println("no tasks recorded.");
                } else {
                    int num = 1;
                    for (Task task : tasks) {
                        System.out.println(num + ". " + task.toString());
                        num++;
                    }
                }
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.equals("bye")) { // end program
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\nbye, see you again~ ꉂ(˵˃ ᗜ ˂˵)" +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n");
                break;
            } else if (input.startsWith("mark ")) { // mark
                int taskNumber = Integer.parseInt(input.substring(5).trim()) - 1;
                if (taskNumber > tasks.size()) {
                    Helpers.taskNotFound();
                    continue;
                }

                tasks.get(taskNumber).markDone();
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\nmarked as done. nice! (˵ •̀ ᴗ - ˵ )\n" +
                        tasks.get(taskNumber).toString() +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.startsWith("unmark ")) { // unmark
                int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                if (taskNumber > tasks.size()) {
                    Helpers.taskNotFound();
                    continue;
                }

                tasks.get(taskNumber).markUndone();
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\nokay, marked as undone. ( ó﹏ò｡ )\n" +
                        tasks.get(taskNumber).toString() +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.startsWith("todo")) { // todo
                if (input.length() <= 5) {
                    Helpers.invalidDescription();
                    continue;
                }

                String desc = input.substring(5).trim();
                tasks.add(new ToDoTask(desc));
                Helpers.taskAdded(desc, tasks.size());
            } else if (input.startsWith("deadline")) { // deadline
                int byIndex = input.indexOf(" /by");
                if (byIndex == -1 || byIndex <= 9 || input.length() <= byIndex + 4) {
                    Helpers.invalidDescription();
                    continue;
                }

                String desc = Helpers.getDeadlineDescription(input);
                String deadline = Helpers.getDeadline(input);
                tasks.add(new DeadlineTask(desc, deadline));
                Helpers.taskAdded(desc, tasks.size());
            } else if (input.startsWith("event")) { // event
                int fromIndex = input.indexOf(" /from");
                int toIndex = input.indexOf(" /to", fromIndex + 1);
                if (fromIndex == -1 || toIndex == -1 || fromIndex <= 5 ||
                    toIndex - (fromIndex + 6) <= 0 || input.length() <= toIndex + 4) {
                    Helpers.invalidDescription();
                    continue;
                }

                String desc = Helpers.getEventDescription(input);
                String start = Helpers.getEventTime(input, true);
                String end = Helpers.getEventTime(input, false);
                tasks.add(new EventTask(desc, start, end));
                Helpers.taskAdded(desc, tasks.size());
            } else {
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\ncommand not recognised. ( • ᴖ • ｡)" +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            }
        }

        scanner.close();
    }
}
