import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

    public static String getDeadlineString(String input) {
        return input.split("/by ")[1];
    }

    public static String getEventString(String input, boolean start) {
        int keyIndex1 = input.indexOf(" /from", 9);
        int keyIndex2 = input.indexOf(" /to", keyIndex1);
        if (start) {
            return input.substring(keyIndex1 + 6, keyIndex2).trim();
        } else {
            return input.substring(keyIndex2 + 4).trim();
        }
    }

    public static LocalDateTime getDateTime(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        try {
            return LocalDateTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}