package Data;

import AllTask.Task;
import Exceptions.DukeException;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list;

    /**
     * Initialise ArrayList of task to the List input.
     *
     * @param list List of task
     */
    public TaskList(ArrayList<Task> list) {
        this.list = list;
    }

    /**
     * Initialise new ArrayList.
     */
    public TaskList() {
        this.list = new ArrayList<Task>();
    }

    /**
     * Get the list of task.
     *
     * @return List of task
     */
    public ArrayList<Task> list() {
        return this.list;
    }

    /**
     * Mark the task in index as done.
     *
     * @param index index of task to mark as done
     * @return Task that is mark as done
     * @throws DukeException Error is input is invalid
     */
    public Task doneTask(int index) throws DukeException {
        try {
            Task done = list.get(index);
            done.Done();
            return done;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("\t \u2639 OOPS!!! The index you entered is not valid.");
        }

    }

    /**
     * Add task into list of task.
     *
     * @param task task to be add
     */
    public void addTask(Task task) {
        list.add(task);
    }

    /**
     * Delete the task at index given.
     *
     * @param index index of task to be deleted
     * @return Task that is deleted
     * @throws DukeException Error is input is invalid
     */
    public Task delTask(int index) throws DukeException {
        try {
            Task del = list.get(index);
            list.remove(index);
            return del;
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("\t \u2639 OOPS!!! The index you entered is not valid.");
        }
    }

    /**
     * Search for task that have the word in the descriptions.
     *
     * @param word String to search for
     * @return list that contains the word
     */
    public ArrayList<Task> find(String word) {
        ArrayList<Task> newlist = new ArrayList<Task>();
        for (Task t : list) {
            if (t.contain(word)) {
                newlist.add(t);
            }
        }
        return newlist;
    }


}
