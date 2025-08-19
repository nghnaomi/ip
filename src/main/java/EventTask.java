public class EventTask extends Task {
    protected String start;
    protected String end;

    public EventTask(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.start + "; to: " + this.end + ")";
    }
}
