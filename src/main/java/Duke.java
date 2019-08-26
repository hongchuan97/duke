import java.util.ArrayList;
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

        ArrayList<Task> list = new ArrayList<Task>();
        Scanner Input = new Scanner(System.in);
        String command = Input.nextLine();
        while (!"bye".equals(command)){
            System.out.println(lines);
            StringTokenizer split = new StringTokenizer(command);
            switch (split.nextToken()){
                case "list" :
                    System.out.println("\t Here are the tasks in your list:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("\t " + (i + 1) + "." + list.get(i).toString());
                    }
                    break;

                case "done" :
                    Task buff = list.get( Integer.parseInt( split.nextToken() ) - 1 );
                    buff.Done();
                    System.out.println("\t Nice! I've marked this task as done:");
                    System.out.println("\t  " + buff.toString());
                    break;

                case "todo" :
                    String description = split.nextToken();
                    while (split.hasMoreTokens()){
                        description += " " + split.nextToken();
                    }
                    Task toDos = new ToDos(description);
                    list.add(toDos);
                    addinterface(toDos , list.size());
                    break;

                case "deadline" :
                    String holder = split.nextToken();
                    String check = split.nextToken();
                    while (!"/by".equals(check)){
                        holder += " " + check;
                        check = split.nextToken();
                    }
                    String by = split.nextToken();
                    while (split.hasMoreTokens()){
                        by += " " + split.nextToken();
                    }
                    Task deadline = new Deadline( holder , by);
                    list.add(deadline);
                    addinterface(deadline , list.size());
                    break;

                case "event" :
                    String eventholder = split.nextToken();
                    String check2 = split.nextToken();
                    while (!"/at".equals(check2)){
                        eventholder += " " + check2;
                        check2 = split.nextToken();
                    }
                    String date = split.nextToken();
                    String time = split.nextToken();
                    Task event = new Event(eventholder , date , time);
                    list.add(event);
                    addinterface(event , list.size());
                    break;

                default:
                    System.out.println("\t \u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
            System.out.println(lines);

            command = Input.nextLine();
        }
            System.out.println(lines);
            System.out.println("\t Bye. Hope to see you again soon!");
            System.out.println(lines);

    }

    private static void addinterface(Task task , int size) {
        System.out.println("\t Got it. I've added this task:");
        System.out.println("\t " + task.toString());
        System.out.println("\t Now you have " + size + " tasks in the list.");
    }

}
