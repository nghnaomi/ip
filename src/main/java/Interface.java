import java.util.List;

public class Interface {
    protected static String logo = "\n   _      _      _      _      _      _   \n"
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

    public static void greet() {
        System.out.println(logo + "\n\nhi i'm alune~ what can i do for you? (⸝⸝ᵕᴗᵕ⸝⸝)" +
                "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public static void farewell() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\nbye, see you again~ ꉂ(˵˃ ᗜ ˂˵)" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n");
    }

    public static void noInput() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                "\n\nno more input. goodbye~ ヾ(＾∇＾)" +
                "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n");
    }

    public static void listTasks(List<Task> tasks) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                "\n\nyour tasks: ᕙ( •̀ ᗜ •́ )ᕗ");
        if (tasks.isEmpty()) {
            System.out.println("no tasks recorded.");
        } else {
            int num = 1;
            for (Task task : tasks) {
                System.out.println(num + ". " + task);
                num++;
            }
        }
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public static void markedDone(Task task) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\nmarked as done. nice! (˵ •̀ ᴗ - ˵ )\n" +
                            task +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public static void markedUndone(Task task) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\nokay, marked as undone. ( ó﹏ò｡ )\n" +
                            task +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public static void taskNotFound() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\ntask does not exist. ∘ ∘ ∘ ( °ヮ° ) ?" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
        return;
    }

    public static void invalidDescription() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                                        "\n\nplease include all required task fields. ( ╥﹏╥ )" +
                                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
        return;
    }

    public static void taskAdded(String desc, int count) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                        "\n\nadded: " + desc +
                        "\nyou have " + count + " task(s) now. („• ֊ •„)੭" +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public static void deletedTask(Task task, int total) {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\ndeleted: " + task.getName() +
                            "\nyou have " + total + " task(s) now. o(≧∇≦o)" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

    public static void invalidCommand() {
        System.out.println("\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»\n" +
                            "\n\ncommand not recognised. ( • ᴖ • ｡)" +
                            "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }

}