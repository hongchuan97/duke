package Data;

import AllTask.Deadline;
import AllTask.Event;
import AllTask.Task;
import AllTask.ToDos;
import Exceptions.DukeException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<Task>();
    private static String filePath = ".\\src\\main\\java\\Data\\duke.txt";
    public static void loadTask(){
        try{
            File fw = new File(filePath);
            Scanner filereader = new Scanner(fw);
            while (filereader.hasNext()){
                parsefile(filereader.nextLine());
            }
        }catch(Exception e){System.out.println(e);}
    }

    private static void parsefile( String line) {
        String[] component = line.split(" \\| ");
        switch (component[0]){
            case "T" :
                Task todo = new ToDos(component[2] , "true".equals(component[1]));
                list.add(todo);
                break;
            case "D" :
                Task deadline = new Deadline(component[2] , "true".equals(component[1]) , component[3]);
                list.add(deadline);
                break;
            case "E" :
                Task event = new Event(component[2] , "true".equals(component[1]) , component[3] ,component[4]);
                list.add(event);
                break;
        }
    }

    public static void saveFile() throws DukeException{
        File f = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(f);
            for (Task t : list) {
                String line;
                if (t instanceof Deadline) {
                    line = ((Deadline) t).saveFormat();
                } else if (t instanceof ToDos) {
                    line = ((ToDos) t).saveFormat();
                } else {
                    line = ((Event) t).saveFormat();
                }
                fileWriter.write(line + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new DukeException("File not found: " + e.getMessage());
        }
    }

    public static void showList(){
        System.out.println("\t Here are the tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t " + (i + 1) + "." + list.get(i).toString());
        }
    }

    public static void doneTask(int index) throws DukeException {
        try {
            Task buff = list.get(index);
            buff.Done();
            System.out.println("\t Nice! I've marked this task as done:");
            System.out.println("\t  " + buff.toString());
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("\t \u2639 OOPS!!! The index you entered is not valid.");
        }

    }

    public static void addTask(Task task){
        list.add(task);
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t " + task.toString());
        System.out.println("\t Now you have " + list.size() + " tasks in the list.");
    }

    public static void delTask(int index) throws DukeException{
        try {
            Task buff = list.get(index);
            System.out.println("\t Noted. I've removed this task: ");
            System.out.println("\t  " + buff.toString());
            list.remove(index);
            System.out.println("\t Now you have " + list.size() + " tasks in the list.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("\t \u2639 OOPS!!! The index you entered is not valid.");
        }
    }
}
