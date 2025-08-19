public class Helpers {
    public static String getDeadlineDescription(String input) {
        String key = " /";
        int keyIndex = input.indexOf(key, 9);
        return input.substring(9, keyIndex).trim();
    }

    public static String getEventDescription(String input) {
        String key = " /";
        int keyIndex = input.indexOf(key, 6);
        return input.substring(6, keyIndex).trim();
    }

    public static String getDeadline(String input) {
        int keyIndex1 = input.indexOf(" /by", 9);
        return input.substring(keyIndex1 + 4).trim();
    }

    public static String getEventTime(String input, boolean start) {
        String key = " /";
        int keyIndex1 = input.indexOf(" /from", 9);
        int keyIndex2 = input.indexOf(" /to", keyIndex1);
        if (start) {
            return input.substring(keyIndex1 + 6, keyIndex2).trim();
        } else {
            return input.substring(keyIndex2 + 4).trim();
        }
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
                        "\n\nadded: " + desc + " („• ֊ •„)੭" +
                        "\nyou now have " + count + " task(s) in the list." +
                        "\n\n\n«────────── « ⋅ʚ♡ɞ⋅ » ──────────»");
    }
}