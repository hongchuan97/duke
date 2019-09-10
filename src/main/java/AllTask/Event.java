package AllTask;

import java.util.Date;

public class Event extends Task {
    protected String date;
    protected String time;

    /**
     * Initialise all varible of event.
     *
     * @param description String that contains description of event.
     * @param done        String that contains the state of event.
     * @param date        String That contains the date of event.
     * @param time        Strings that contains the time of the event.
     */
    public Event(String description, boolean done, String date, String time) {
        super(description, done);
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + date + " " + time + ")";
    }

    public String saveFormat() {
        return "E | " + super.isDone + " | " + super.description + " | " + this.date + " | " + this.time;
    }
}
