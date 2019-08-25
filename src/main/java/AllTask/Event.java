package AllTask;

public class Event extends Task {
    protected String date;
    protected String time;
    public Event(String description , boolean done , String date , String time){
        super(description , done);
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (by: " + date + " " + time + ")";
    }
    public String saveFormat() {return "E | " + super.isDone + " | " + super.description + " | " + this.date + " | " + this.time;}
}
