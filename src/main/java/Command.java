public enum Command {
    LIST, BYE, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE, UNKNOWN;

    public static Command fromString(String input) {
        if (input == null) return null;
        switch (input.toLowerCase()) {
            case "list": return LIST;
            case "bye": return BYE;
            case "mark": return MARK;
            case "unmark": return UNMARK;
            case "todo": return TODO;
            case "deadline": return DEADLINE;
            case "event": return EVENT;
            case "delete": return DELETE;
            default: return UNKNOWN;
        }
    }
}