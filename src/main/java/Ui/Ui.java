package Ui;

import AllTask.Task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ui {
    public static void showExit() {
        System.out.println("\t Bye. Hope to see you again soon!");
    }

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

    public void showLine() {
        String lines = "\t____________________________________________________________";
        System.out.println(lines);
    }

    public StringTokenizer readCommand() {
        Scanner Input = new Scanner(System.in);
        return new StringTokenizer(Input.nextLine());
    }

    public void showError(String message) {
        System.out.println("\t " + message);
    }

    public void showLoadingError() {
        System.out.println("\t Failed to load file");
    }

    public void showList(ArrayList<Task> list) {
        System.out.println("\t Here are the tasks in your list:");
        printList(list);
    }
    public void printList(ArrayList<Task> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\t " + (i + 1) + "." + list.get(i).toString());;
        }
    }

    public void showDone(Task done) {
        System.out.println("\t Nice! I've marked this task as done:");
        System.out.println("\t " + done.toString());
    }

    public void showSize(ArrayList<Task> list){
        System.out.println("\t Now you have " + list.size() + " tasks in the list.");
    }

    public void showAdded(Task add) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t " + add.toString());
    }

    public void showDel(Task del) {
        System.out.println("\t Noted. I've removed this task: ");
        System.out.println("\t  " + del.toString());
    }

    public void showMatch(ArrayList<Task> list) {
        System.out.println("\t Here are the matching tasks in your list:");
        printList(list);
    }
}
