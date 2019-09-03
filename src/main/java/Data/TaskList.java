package Data;

import AllTask.Task;
import Exceptions.DukeException;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    public TaskList(ArrayList<Task> list){
        this.list = list;
    }
    public TaskList(){
        this.list = new ArrayList<Task>();
    }
    public ArrayList<Task> list(){
        return this.list;
    }
    public Task doneTask(int index) throws DukeException {
        try {
            Task done = list.get(index);
            done.Done();
            return done;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("\t \u2639 OOPS!!! The index you entered is not valid.");
        }

    }

    public void addTask(Task task){
        list.add(task);
    }

    public Task delTask(int index) throws DukeException{
        try {
            Task del= list.get(index);
            list.remove(index);
            return del;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("\t \u2639 OOPS!!! The index you entered is not valid.");
        }
    }
    public ArrayList<Task> find(String word , ArrayList<Task> list){
        ArrayList<Task> newlist = new ArrayList<Task>();
        for(Task t : list){
            if(t.contain(word)){
                newlist.add(t);
            }
        }
        return newlist;
    }


}
