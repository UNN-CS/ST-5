import com.example.Sqrt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SqrtTest {
    @Test
    public void testCalcPositiveNumber() {
        Sqrt sqrt = new Sqrt(16);
        assertEquals(4.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testCalcFractionalNumber() {
        Sqrt sqrt = new Sqrt(2.25);
        assertEquals(1.5, sqrt.calc(), 0.000001);
    }

    @Test
    public void testCalcLargeNumber() {
        Sqrt sqrt = new Sqrt(10000);
        assertEquals(100.0, sqrt.calc(), 0.000001);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(16);
        assertEquals(2.5, sqrt.average(2, 3), 0.000001);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(16);
        assertTrue(sqrt.good(4.0, 16));
        assertFalse(sqrt.good(4.1, 16));
    }

    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(25);
        assertEquals(5.0, sqrt.iter(1.0, 25), 0.0001);
    }
    @Test
    public void testCalc() {
        Sqrt sqrt = new Sqrt(144);
        assertEquals(12.0, sqrt.calc(), 0.0001);
    }
    @Test
    public void testCalcWithZero() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(0.0, sqrt.calc(), 0.0001);
    }


}
