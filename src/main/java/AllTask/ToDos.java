package AllTask;

public class ToDos extends Task {
    public ToDos(String description , boolean done){
        super(description, done);
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
}
    public String saveFormat() {return "T | " + super.isDone + " | " + super.description;}
}
