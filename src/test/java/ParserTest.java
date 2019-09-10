import AllTask.ToDos;
import Command.*;
import Exceptions.DukeException;
import Parser.Parser;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    @Test
    void TestParse(){
        String task= "todo mon";
        StringTokenizer todo = new StringTokenizer(task);

        String task2= "bye";
        StringTokenizer exit = new StringTokenizer(task2);

        String task3 = "list";
        StringTokenizer show = new StringTokenizer(task3);

        String task4 = "find";
        StringTokenizer find = new StringTokenizer(task4);

        String task5 = "delete";
        StringTokenizer del = new StringTokenizer(task5);

        String task6 = "done 1";
        StringTokenizer done = new StringTokenizer(task6);
        try{
            System.out.println("Testing Parse");
            assertTrue(Parser.parse(todo) instanceof AddCommand);
            assertTrue(Parser.parse(exit) instanceof ExitCommand);
            assertTrue(Parser.parse(show) instanceof ShowCommand);
            assertTrue(Parser.parse(find) instanceof FindCommand);
            assertTrue(Parser.parse(del) instanceof DelCommand);
            assertTrue(Parser.parse(done) instanceof DoneCommand);
        } catch (Exception e) {
            System.out.println("Fail parse");
        }
    }
}
