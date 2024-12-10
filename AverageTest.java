import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AverageTest {

    @Test
    void testValidInputs() {
        Average avg = new Average();
        assertEquals(20, avg.average(3, new int[]{10, 20, 30, 40, 50}));
        assertEquals(6, avg.average(2, new int[]{4, 8}));
    }

    @Test
    void testInvalidInputs() {
        Average avg = new Average();
        assertEquals(0, avg.average(0, new int[]{10, 20, 30}));
        assertEquals(0, avg.average(-1, new int[]{10, 20, 30}));
    }

    @Test
    void testBoundaryValues() {
        Average avg = new Average();
        assertEquals(10, avg.average(1, new int[]{10}));
        assertEquals(2, avg.average(4, new int[]{1, 2, 3}));
    }

    @Test
    void testEmptyList() {
        Average avg = new Average();
        assertEquals(0, avg.average(3, new int[]{}));
    }

    @Test
    void testExceedingListSize() {
        Average avg = new Average();
        assertEquals(2, avg.average(5, new int[]{1, 2, 3}));
    }

    @Test
    void testSingleElementList() {
        Average avg = new Average();
        assertEquals(7, avg.average(1, new int[]{7}));
        assertEquals(7, avg.average(2, new int[]{7}));
    }
}
