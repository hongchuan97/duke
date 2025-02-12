package AllTask;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * AllTask.Task constructor
     *
     * @param description The description of the task
     * @param done        The state of task
     */
    public Task(String description, boolean done) {
        this.description = description;
        this.isDone = done;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void Done() {
        this.isDone = true;
    }

    public boolean contain(String word) {
        return description.contains(word);
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    //...
}

