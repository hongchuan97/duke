import java.util.ArrayList;
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

        ArrayList<String> list = new ArrayList<String>();
        Scanner Input = new Scanner(System.in);
        String command = Input.nextLine();
        while (!"bye".equals(command)){
            if(!"list".equals(command)){
                list.add(command);
                System.out.println(horilines);
                System.out.println("\t Added: "+ command);
                System.out.println(horilines);
            }else{
                System.out.println(horilines);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(" " + (i + 1) + ". " + list.get(i));
                }
                System.out.println(horilines);
            }

            command = Input.nextLine();
        }
            System.out.println(horilines);
            System.out.println("\t Bye. Hope to see you again soon!");
            System.out.println(horilines);

    }
}
