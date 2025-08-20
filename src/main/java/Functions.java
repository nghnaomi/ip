public class Functions {
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
}