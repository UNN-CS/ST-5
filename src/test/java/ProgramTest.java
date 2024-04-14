import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProgramTest {

    @Test
    public void testSqrtCalc() {
        double val = 4.0;
        double expected = Math.sqrt(val);
        Sqrt sqrt = new Sqrt(val);
        double result = sqrt.calc();
        assertEquals(expected, result, 0.000001);
    }

    @Test
    public void testAverage() {
        Sqrt sqrt = new Sqrt(0);
        double x = 3.0;
        double y = 5.0;
        double expected = (x + y) / 2.0;
        double result = sqrt.average(x, y);
        assertEquals(expected, result, 0.000001);
    }

    @Test
    public void testGood() {
        Sqrt sqrt = new Sqrt(0);
        double guess = 2.0;
        double x = 4.0;
        boolean expected = true;
        boolean result = sqrt.good(guess, x);
        assertEquals(expected, result);
    }

    @Test
    public void testImprove() {
        Sqrt sqrt = new Sqrt(0);
        double guess = 2.0;
        double x = 4.0;
        double expected = (guess + x / guess) / 2.0;
        double result = sqrt.improve(guess, x);
        assertEquals(expected, result, 0.000001);
    }

    @Test
    public void testIter() {
        double val = 4.0;
        Sqrt sqrt = new Sqrt(val);
        double guess = 2.0;
        double expected = Math.sqrt(val);
        double result = sqrt.iter(guess, val);
        assertEquals(expected, result, 0.000001);
    }

     /*
    @Test
    public void testCalcForZero() {
        double val = 0.0;
        double expected = Math.sqrt(val);
        Sqrt sqrt = new Sqrt(val);
        double result = sqrt.calc();
        assertEquals(expected, result, 0.000001);
    }

    @Test
    public void testCalcForNegative() {
        double val = -4.0;
        double expected = Math.sqrt(Math.abs(val));
        Sqrt sqrt = new Sqrt(val);
        double result = sqrt.calc();
        assertEquals(expected, result, 0.000001);
    }
      */
}