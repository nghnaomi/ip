package alune.ui;
import alune.tasks.Task;
import alune.tasks.TaskList;

/** This class handles the UI of the program's responses to users.
 *  @author nghnaomi */

public class UI {
    protected String logo = "\n"
        + "        __                       \n"
        + "_____  |  |  __ __  ____   ____  \n"
        + "\\__  \\ |  | |  |  \\/    \\_/ __ \\ \n"
        + " / __ \\|  |_|  |  /   |  \\  ___/ \n"
        + "(____  /____/____/|___|  /\\___  >\n"
        + "     \\/                \\/     \\/ \n";

    public void greet() {
        System.out.println(logo + "\n\nhi i'm alune~ what can i do for you? (⸝⸝ᵕᴗᵕ⸝⸝)" +
                "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void farewell() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\nbye, see you again~ ꉂ(˵˃ ᗜ ˂˵)" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n");
    }

    public void noInput() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                "\n\nno more input. goodbye~ ヾ(＾∇＾)" +
                "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n");
    }

    public void listTasks(TaskList tasks) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                "\n\nyour tasks: ᕙ( •̀ ᗜ •́ )ᕗ");
        if (tasks.isEmpty()) {
            System.out.println("no tasks recorded.");
        } else {
            tasks.printTasks();
        }
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void markedDone(Task task) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\nmarked as done. nice! (˵ •̀ ᴗ - ˵ )\n" +
                            task +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void markedUndone(Task task) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\nokay, marked as undone. ( ó﹏ò｡ )\n" +
                            task +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void taskNotFound() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\ntask does not exist. ∘ ∘ ∘ ( °ヮ° ) ?" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void invalidInput() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\ninvalid input, please try again. ( ╥﹏╥ )" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void invalidDateTime() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nplease use dd/mm/yyyy hhmm format. (,,>﹏<,,)" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void taskAdded(String desc, int count) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\nadded: " + desc +
                        "\nyou have " + count + " task(s) now. („• ֊ •„)੭" +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void deletedTask(Task task, int total) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\ndeleted: " + task.getName() +
                            "\nyou have " + total + " task(s) now. o(≧∇≦o)" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void wipedTasks(int total) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\nwiped " + total + " tasks from the list! (￣^￣ )ゞ" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public void invalidCommand() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\ncommand not recognised. ( • ᴖ • ｡)" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

}