package Ui;

import AllTask.Task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ui {

    private Scanner Input = new Scanner(System.in);

    /**
     * Print welcome interface.
     */
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        showLine();
        System.out.println("\t Hello! I'm Duke \n\t What can I do for you?");
        showLine();
    }

    /**
     * Print dividing line.
     */
    public void showLine() {
        String lines = "\t____________________________________________________________";
        System.out.println(lines);
    }

    /**
     * Reads inputs from users.
     *
     * @return User input in form of token.
     */
    public StringTokenizer readCommand() {
        return new StringTokenizer(this.Input.nextLine());
    }

    /**
     * Print error message.
     *
     * @param message String that contains error message.
     */
    public void showError(String message) {
        System.out.println("\t " + message);
    }

    /**
     * Print loading error interface.
     */
    public void showLoadingError() {
        System.out.println("\t Failed to load file");
    }

    /**
     * Print show task interface.
     *
     * @param list ArrayList of task to be printed.
     */
    public void showList(ArrayList<Task> list) {
        System.out.println("\t Here are the tasks in your list:");
        printList(list);
    }

    /**
     * Print the list of task.
     *
     * @param list ArrayList of task to be printed.
     */
    public void printList(ArrayList<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t " + (i + 1) + "." + list.get(i).toString());
            ;
        }
    }

    /**
     * Print done task interface.
     *
     * @param done Task object that is done.
     */
    public void showDone(Task done) {
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t " + done.toString());
    }

    /**
     * Print the size of the list provided.
     *
     * @param list ArrayList of task.
     */
    public void showSize(ArrayList<Task> list) {
        System.out.println("\t Now you have " + list.size() + " tasks in the list.");
    }

    /**
     * Print add task interface.
     *
     * @param add Task object that is added.
     */
    public void showAdded(Task add) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t " + add.toString());
    }

    /**
     * Print delete interface.
     *
     * @param del Task object that is deleted.
     */
    public void showDel(Task del) {
        System.out.println("\t Noted. I've removed this task: ");
        System.out.println("\t  " + del.toString());
    }

    /**
     * Print ShowList interface.
     *
     * @param list The list of task to print.
     */
    public void showMatch(ArrayList<Task> list) {
        System.out.println("\t Here are the matching tasks in your list:");
        printList(list);
    }

    /**
     * Print exit interface.
     */
    public static void showExit() {
        System.out.println("\t Bye. Hope to see you again soon!");
    }
}
