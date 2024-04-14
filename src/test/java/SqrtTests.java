import pozvas.Sqrt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SqrtTests {
    @Test
    public void testSqrtOfZero() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.calc(), 0.0001);
    }

    @Test
    public void testSqrtOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(81);
        assertEquals(9.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfNotPerfectSquare() {
        Sqrt sqrt = new Sqrt(56);
        assertEquals(Math.sqrt(56), sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfNegativeNumber() {
        Sqrt sqrt = new Sqrt(-10);
        assertThrows(Throwable.class, sqrt::calc);
    }

    @Test
    public void testSqrtOfLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000);
        assertEquals(1000.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfFraction() {
        Sqrt sqrt = new Sqrt(0.36);
        assertEquals(0.6, sqrt.calc(), 0.000001);
    }
}
