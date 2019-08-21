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
        String horilines = "\t____________________________________________________________";
        System.out.println(horilines);
        System.out.println("\t Hello! I'm Duke \n\t What can I do for you?");
        System.out.println(horilines);

        ArrayList<Task> list = new ArrayList<Task>();
        Scanner Input = new Scanner(System.in);
        String command = Input.nextLine();
        while (!"bye".equals(command)){
            System.out.println(horilines);
            if(!"list".equals(command)){

                StringTokenizer split = new StringTokenizer(command);
                if(!"done".equals(split.nextToken())){
                    Task buffer = new Task(command);
                    list.add(buffer);
                    System.out.println("\t Added: "+ command);
                }else{
                    Task buff = list.get( Integer.parseInt( split.nextToken() ) - 1 );
                    buff.Done();
                    System.out.println("\t Nice! I've marked this task as done:");
                    System.out.println("\t  [" + buff.getStatusIcon() + "] " + buff.description);
                }

            }else{
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("\t " + (i + 1) + ".[" + list.get(i).getStatusIcon() + "] " + list.get(i).description);
                }

            }
            System.out.println(horilines);

            command = Input.nextLine();
        }
            System.out.println(horilines);
            System.out.println("\t Bye. Hope to see you again soon!");
            System.out.println(horilines);

    }

    public static class Task {
        protected String description;
        protected boolean isDone;

        /**
         * Task constructor
         * @param description The description of the task
         */
        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        public void Done(){
            this.isDone = true;
        }

        //...
    }

}
