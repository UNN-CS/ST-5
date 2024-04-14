import marissa.Sqrt;
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
    public void testBadSquare() {
        Sqrt sqrt = new Sqrt(5);
        assertEquals(Math.sqrt(5), sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfNegativeNumber() {
        Sqrt sqrt = new Sqrt(-12);
        assertThrows(Throwable.class, sqrt::calc);
    }

    @Test
    public void testSqrtOfMaxValue() {
        Sqrt sqrt = new Sqrt(Double.MAX_VALUE);
        double result = sqrt.calc();
        assertEquals(false, Double.isNaN(result));
    }
    
    @Test
    public void testSqrtOfLargeNumber() {
        Sqrt sqrt = new Sqrt(1000000);
        assertEquals(1000.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfFraction() {
        Sqrt sqrt = new Sqrt(0.16);
        assertEquals(0.4, sqrt.calc(), 0.000001);
    }

    @Test
    public void testNormalSquare() {
        Sqrt sqrt = new Sqrt(4);
        assertEquals(2.0, sqrt.calc(), 0.000001);
    }
}