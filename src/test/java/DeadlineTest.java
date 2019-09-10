import AllTask.*;
import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    Deadline deadline = new Deadline("return book", false, "June 6th");

    @Test
    void TestToString() {
        assertEquals(deadline.toString(), "[D][" + "\u2718" + "] return book (by: June 6th)");
    }

    @Test
    void TestSaveFormat() {
        assertEquals(deadline.saveFormat(), "D | false | return book | June 6th");
    }
}
