import org.junit.Test;
import static org.junit.Assert.*;

public class SqrtTests {
    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(4.5, sqrt.average(3, 6), 0.0001);
        assertEquals(0, sqrt.average(0, 0), 0.0001);
        assertEquals(1.5, sqrt.average(1, 2), 0.0001);
        assertEquals(9.0, sqrt.average(11, 7), 0.0001);
        assertEquals(15.5, sqrt.average(25, 6), 0.0001);
        assertEquals(11.5, sqrt.average(21, 2), 0.0001);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(0);
        assertTrue(sqrt.good(0.0001, 0.00000001));
        assertFalse(sqrt.good(0.1, 0.00000001));

        assertTrue(sqrt.good(0.0000001, 0.00000000001));
        assertFalse(sqrt.good(10, 10000));
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(26.0, sqrt.improve(2, 100), 0.0001);
        assertEquals(1.5, sqrt.improve(1, 2), 0.0001);
    }

    @Test
    public void testIter() {
        Sqrt sqrt = new Sqrt(0);
        assertEquals(3.0, sqrt.iter(1, 9), 0.0001);
        assertEquals(2.0, sqrt.iter(1, 4), 0.0001);

        assertEquals(3.0, sqrt.iter(2, 9), 0.0001);
        assertEquals(2.0, sqrt.iter(2, 4), 0.0001);
    }

    @Test
    public void testCalc() {
        Sqrt sqrt = new Sqrt(9);
        assertEquals(3.0, sqrt.calc(), 0.0001);

        sqrt = new Sqrt(16);
        assertEquals(4.0, sqrt.calc(), 0.0001);

        sqrt = new Sqrt(25);
        assertEquals(5.0, sqrt.calc(), 0.0001);
    }

    @Test
    public void textEx() {
        Sqrt sqrt = new Sqrt(-25); // Square root of a negative number should return NaN
        assertThrows(Throwable.class, sqrt::calc);
    }

}
