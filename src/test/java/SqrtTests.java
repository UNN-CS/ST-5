import frenetz.Sqrt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SqrtTests {
    @Test
    public void testSqrtOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(36);
        assertEquals(6.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(32);
        assertEquals(Math.sqrt(32), sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfZero() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.calc(), 0.0001);
    }

    @Test
    public void testSqrtOfNegativeNumber() {
        Sqrt sqrt = new Sqrt(-36);
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

    @Test
    public void testSqrtOfMaxValue() {
        Sqrt sqrt = new Sqrt(Double.MAX_VALUE);
        double result = sqrt.calc();
        assertEquals(false, Double.isNaN(result));
    }
}
