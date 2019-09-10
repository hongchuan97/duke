package Parser;

import Command.Command;
import Exceptions.DukeException;
import AllTask.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import Command.*;

public class Parser {
    /**
     * Parse string into individual commands according to string.
     *
     * @param msg The entire command string in the form of token.
     * @return Command object according to the string.
     * @throws DukeException Error if input is incorrect
     */
    public static Command parse(StringTokenizer msg) throws DukeException {
        switch (msg.nextToken()) {
            case "bye":
                return new ExitCommand();

            case "list":
                return new ShowCommand();

            case "done":
                try {
                    return new DoneCommand(Integer.parseInt(msg.nextToken()));
                } catch (NoSuchElementException e) {
                    throw new DukeException(" \u2639 OOPS!!! Please enter the index of which task to be done.");
                }

            case "todo":
                try {
                    String description = msg.nextToken();
                    while (msg.hasMoreTokens()) {
                        description += " " + msg.nextToken();
                    }
                    Task toDos = new ToDos(description, false);
                    return new AddCommand(toDos);
                } catch (NoSuchElementException e) {
                    throw new DukeException(" \u2639 OOPS!!! The description of a todo cannot be empty.");
                }

            case "deadline":
                try {
                    String holder = msg.nextToken();
                    String check = msg.nextToken();
                    while (!"/by".equals(check)) {
                        holder += " " + check;
                        check = msg.nextToken();
                    }
                    String by = parseDate(msg.nextToken());

                    Task deadline = new Deadline(holder, false, by);
                    return new AddCommand(deadline);
                } catch (NoSuchElementException e) {
                    throw new DukeException(" \u2639 OOPS!!! Error in deadline input.");
                }

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
                    Task event = new Event(eventholder, false, date, time);
                    return new AddCommand(event);
                } catch (NoSuchElementException e) {
                    throw new DukeException(" \u2639 OOPS!!! Error in event input.");
                }
            case "delete":
                try {
                    return new DelCommand(Integer.parseInt(msg.nextToken()));
                } catch (NoSuchElementException e) {
                    throw new DukeException(" \u2639 OOPS!!! Please enter the index of which task to be deleted.");
                }
            case "find":
                try {
                    String keyword = msg.nextToken();
                    while (msg.hasMoreTokens()) {
                        keyword += " " + msg.nextToken();
                    }
                    return new FindCommand(keyword);
                } catch (NoSuchElementException e) {
                    throw new DukeException(" \u2639 OOPS!!!");
                }
            default:
                throw new DukeException(" \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }

    /**
     * Reformat time from 24hour notation to 12hour notation.
     *
     * @param time String of time in 24hour notation.
     * @return String of time in 12hour notation.
     * @throws DukeException Error if time input is incorrect
     */
    private static String parseTime(String time) throws DukeException {
        try {
            SimpleDateFormat Format = new SimpleDateFormat("HHmm");
            Date dateForm = Format.parse(time);
            SimpleDateFormat newFormat = new SimpleDateFormat("K:mmaa");
            return newFormat.format(dateForm);
        } catch (ParseException e) {
            throw new DukeException(e.getMessage());
        }
    }

    /**
     * Reformat the date from dd/MM/yyyy to month and date.
     *
     * @param date String of date in dd/MM/yyyy.
     * @return String of date in month and date.
     * @throws DukeException Error if date format is incorrect
     */
    private static String parseDate(String date) throws DukeException {
        try {
            SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");
            Date dateForm = Format.parse(date);
            SimpleDateFormat newFormat = new SimpleDateFormat("MMM dd");
            return newFormat.format(dateForm);
        } catch (ParseException e) {
            throw new DukeException(e.getMessage());
        }
    }

}
