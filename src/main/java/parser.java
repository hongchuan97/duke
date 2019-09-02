import Exceptions.DukeException;
import AllTask.*;
import Data.TaskList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class parser {
    public static void commands(StringTokenizer msg) throws DukeException {
        switch (msg.nextToken()) {
            case "list":
                TaskList.showList();
                break;

            case "done":
                try {
                    TaskList.doneTask(Integer.parseInt(msg.nextToken()) - 1);
                } catch (NoSuchElementException e) {
                    throw new DukeException("\t \u2639 OOPS!!! Please enter the index of which task to be done.");
                } catch (DukeException e) {
                    throw e;
                }
                break;

            case "todo":
                try {
                    String description = msg.nextToken();
                    while (msg.hasMoreTokens()) {
                        description += " " + msg.nextToken();
                    }
                    Task toDos = new ToDos(description , false);
                    TaskList.addTask(toDos);
                } catch (NoSuchElementException e) {
                    throw new DukeException("\t \u2639 OOPS!!! The description of a todo cannot be empty.");
                }
                break;

            case "deadline":
                try {
                    String holder = msg.nextToken();
                    String check = msg.nextToken();
                    while (!"/by".equals(check)) {
                        holder += " " + check;
                        check = msg.nextToken();
                    }
                    String by = parseDate(msg.nextToken());

                    Task deadline = new Deadline(holder, false , by);
                    TaskList.addTask(deadline);
                } catch (NoSuchElementException e) {
                    throw new DukeException("\t \u2639 OOPS!!! Error in deadline input.");
                }

                break;

            case "event":
                try {
                    String eventholder = msg.nextToken();
                    String check2 = msg.nextToken();
                    while (!"/at".equals(check2)) {
                        eventholder += " " + check2;
                        check2 = msg.nextToken();
                    }
                    String date = parseDate(msg.nextToken());
                    String time = parseTime(msg.nextToken());
                    Task event = new Event(eventholder, false , date, time);
                    TaskList.addTask(event);
                } catch (NoSuchElementException e) {
                    throw new DukeException("\t \u2639 OOPS!!! Error in event input.");
                }
                break;
            case "find":
                try{
                    String keyword = msg.nextToken();
                    while (msg.hasMoreTokens()){
                        keyword += " " + msg.nextToken();
                    }
                    TaskList.find(keyword);
                }catch (NoSuchElementException e){
                    throw new DukeException("\t \u2639 OOPS!!!");
                }
                break;
            default:
                throw new DukeException("\t \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    private static String parseTime(String time) throws DukeException{
        try {
            SimpleDateFormat Format = new SimpleDateFormat("HHmm");
            Date dateForm = Format.parse(time);
            SimpleDateFormat newFormat = new SimpleDateFormat("K:mmaa");
            return newFormat.format(dateForm);
        } catch (ParseException e){
            throw new DukeException(e.getMessage());
        }
    }

    public static String parseDate(String date) throws DukeException{
        try {
            SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateForm = Format.parse(date);
            SimpleDateFormat newFormat = new SimpleDateFormat("MMM dd");
            return newFormat.format(dateForm);
        } catch (ParseException e){
            throw new DukeException(e.getMessage());
        }
    }

}
