import Exceptions.DukeException;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Duke {
    /**
     * Main class.
     * @param args empty for now.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        String lines = "\t____________________________________________________________";

        System.out.println(lines);
        System.out.println("\t Hello! I'm Duke \n\t What can I do for you?");
        System.out.println(lines);

        Scanner Input = new Scanner(System.in);
        String command = Input.nextLine();
        while (!"bye".equals(command)){
            System.out.println(lines);
            StringTokenizer split = new StringTokenizer(command);
            try{
                parser.commands(split);
            } catch (DukeException err){
                System.out.println(err.getMessage());
            }
            System.out.println(lines);

            command = Input.nextLine();
        }
            System.out.println(lines);
            System.out.println("\t Bye. Hope to see you again soon!");
            System.out.println(lines);

    }



}
