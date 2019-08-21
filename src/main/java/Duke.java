import java.util.Scanner;

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
        String horilines = "\t____________________________________________________________";
        System.out.println(horilines);
        System.out.println("\t Hello! I'm Duke \n\t What can I do for you?");
        System.out.println(horilines);
        Scanner Input = new Scanner(System.in);
        String command = Input.nextLine();
        while (!"bye".equals(command)){
            System.out.println(horilines);
            System.out.println("\t "+ command);
            System.out.println(horilines);
            command = Input.nextLine();
        }
            System.out.println(horilines);
            System.out.println("\t Bye. Hope to see you again soon!");
            System.out.println(horilines);

    }
}
