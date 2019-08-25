package AllTask;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, boolean done , String by) {
        super(description , done);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
    public String saveFormat() {return "D | " + super.isDone + " | " + super.description + " | " + this.by;}
}
