package alune;
public enum Commands {
    LIST, BYE, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE, WIPE, UNKNOWN;

    public static Commands fromString(String input) {
        if (input == null) {
            return null;
        }
        return switch (input.toLowerCase()) {
            case "list" -> LIST;
            case "bye" -> BYE;
            case "mark" -> MARK;
            case "unmark" -> UNMARK;
            case "todo" -> TODO;
            case "deadline" -> DEADLINE;
            case "event" -> EVENT;
            case "delete" -> DELETE;
            case "wipe" -> WIPE;
            default -> UNKNOWN;
        };
    }
}