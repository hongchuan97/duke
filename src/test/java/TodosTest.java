import AllTask.ToDos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTest {
    ToDos task = new ToDos("return book", false);

    @Test
    void TestToString() {
        assertEquals(task.toString(), "[T][" + "\u2718" + "] return book");
    }

    @Test
    void TestSaveFormat() {
        assertEquals(task.saveFormat(), "T | false | return book");
    }
}
