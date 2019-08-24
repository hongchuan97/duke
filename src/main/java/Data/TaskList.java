package Data;

import AllTask.Task;
import Exceptions.DukeException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<Task>();
    public static void showList(){
        System.out.println("\t Here are the tasks in your list:");
        for (int i = 0; i < TaskList.list.size(); i++) {
            System.out.println("\t " + (i + 1) + "." + TaskList.list.get(i).toString());
        }
    }

    public static void doneTask(int index) throws DukeException {
        try {
            Task buff = TaskList.list.get(index);
            buff.Done();
            System.out.println("\t Nice! I've marked this task as done:");
            System.out.println("\t  " + buff.toString());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("\t \u2639 OOPS!!! The index you entered is not valid.");
        }

    }

    public static void addTask(Task task){
        TaskList.list.add(task);
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t " + task.toString());
        System.out.println("\t Now you have " + TaskList.list.size() + " tasks in the list.");
    }
}
