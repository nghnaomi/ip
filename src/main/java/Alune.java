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
            String input = scanner.nextLine().trim().toLowerCase();
            int totalTasks = 0;
            
            if (input.equals("list")) { // list
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nyour tasks: ᕙ( •̀ ᗜ •́ )ᕗ");
                if (tasks.size() == 0) {
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
                if (taskNumber > totalTasks) {
                    System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\ntask does not exist. ∘ ∘ ∘ ( °ヮ° ) ?" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
                    continue;
                }
                tasks.get(taskNumber).markDone();
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nmarked as done. nice! (˵ •̀ ᴗ - ˵ )\n" +
                                        tasks.get(taskNumber).toString() +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.startsWith("unmark ")) { // unmark
                int taskNumber = Integer.parseInt(input.substring(7).trim()) - 1;
                if (taskNumber > totalTasks) {
                    System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\ntask does not exist. ∘ ∘ ∘ ( °ヮ° ) ?" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
                    continue;
                }
                tasks.get(taskNumber).markUndone();
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nokay, marked as undone. ( ó﹏ò｡ )\n" +
                                        tasks.get(taskNumber).toString() +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.startsWith("todo")) { // todo
                totalTasks++;
                String desc = input.substring(5).trim();
                tasks.add(new ToDoTask(desc));
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nadded: " + desc + " („• ֊ •„)੭" +
                                        "\nyou now have " + totalTasks + " task(s) in the list." +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.startsWith("deadline")) { // deadline
                totalTasks++;
                String desc = Helpers.getDeadlineDescription(input);
                String deadline = Helpers.getDeadline(input);
                tasks.add(new DeadlineTask(desc, deadline));
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nadded: " + desc + " („• ֊ •„)੭" +
                                        "\nyou now have " + totalTasks + " task(s) in the list." +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else if (input.startsWith("event")) { // event
                totalTasks++;
                String desc = Helpers.getEventDescription(input);
                String start = Helpers.getEventTime(input, true);
                String end = Helpers.getEventTime(input, false);
                tasks.add(new EventTask(desc, start, end));
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nadded: " + desc + " („• ֊ •„)੭" +
                                        "\nyou now have " + totalTasks + " task(s) in the list." +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            } else {
                System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\ncommand not recognised. ( • ᴖ • ｡)" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
            }
        }
        
        scanner.close();
    }
}
