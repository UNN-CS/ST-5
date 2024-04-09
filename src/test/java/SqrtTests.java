import dmitryvnn.Sqrt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SqrtTests {

    @Test
    public void testSqrtOfPerfectSquare() {
        Sqrt sqrt = new Sqrt(25); // Square root of 25 is 5
        assertEquals(5.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfNonPerfectSquare() {
        Sqrt sqrt = new Sqrt(30); // Square root of 30 is approximately 5.477
        assertEquals(Math.sqrt(30), sqrt.calc(), 0.000001);
    }

    @Test
    public void testSqrtOfZero() {
        Sqrt sqrt = new Sqrt(0); // Square root of 0 is 0
        assertEquals(0.0, sqrt.calc(), 0.0001);
    }

    @Test
    public void testSqrtOfNegativeNumber() {
        Sqrt sqrt = new Sqrt(-25); // Square root of a negative number should return NaN
        assertThrows(Throwable.class, sqrt::calc);
    }


}
