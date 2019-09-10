import AllTask.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    Event task = new Event("books", false , "Jan 01" , "3:30PM");

    @Test
    void TestToString() {
        assertEquals(task.toString(), "[E][" + "\u2718" + "] books (at: Jan 01 3:30PM)");
    }

    @Test
    void TestSaveFormat() {
        assertEquals(task.saveFormat(), "E | false | books | Jan 01 | 3:30PM");
    }
}
