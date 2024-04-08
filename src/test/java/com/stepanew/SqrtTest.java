package com.stepanew;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Sqrt Test")
public class SqrtTest {

    private static final double EPS = 0.001;
    private static final double SQRT_CORE = 9;

    @ParameterizedTest
    @CsvSource({ "1, 1, 1", "0, 0, 0", "5, 13, 9", "1000, 1500, 1250" })
    @DisplayName("Average Test")
    public void averageTest(double leftOperand, double rightOperand, double result) {
        final var sqrt = new Sqrt(SQRT_CORE);

        final var average = sqrt.average(leftOperand, rightOperand);

        Assertions.assertEquals(result, average, EPS);
    }

    @ParameterizedTest
    @CsvSource({ "2, 4", "3, 9", "15, 225", "100, 10000" })
    @DisplayName("Good test (true)")
    public void goodTestTrue(double leftOperand, double rightOperand) {
        final var sqrt = new Sqrt(SQRT_CORE);

        final var good = sqrt.good(leftOperand, rightOperand);

        Assertions.assertTrue(good);
    }

    @ParameterizedTest
    @CsvSource({ "1.9, 4", "3.1, 9", "15.01, 225", "99.999999, 10000" })
    @DisplayName("Good test (false)")
    public void goodTestFalse(double leftOperand, double rightOperand) {
        final var sqrt = new Sqrt(SQRT_CORE);

        final var good = sqrt.good(leftOperand, rightOperand);

        Assertions.assertFalse(good);
    }

    @ParameterizedTest
    @CsvSource({ "1, 1, 1", "2, 2, 1.5", "5, 13, 3.8", "1000, 1500, 500.75" })
    @DisplayName("Improve Test")
    public void improveTest(double leftOperand, double rightOperand, double result) {
        final var sqrt = new Sqrt(SQRT_CORE);

        final var improve = sqrt.improve(leftOperand, rightOperand);

        Assertions.assertEquals(result, improve, EPS);
    }

    @ParameterizedTest
    @CsvSource({ "0, 0, 0", "1, 1, 1", "1, 4, 2", "10, 2500, 50" })
    @DisplayName("Iter Test")
    public void iterTest(double leftOperand, double rightOperand, double result) {
        final var sqrt = new Sqrt(SQRT_CORE);

        final var iter = sqrt.iter(leftOperand, rightOperand);

        Assertions.assertEquals(result, iter, EPS);
    }

    @ParameterizedTest
    @CsvSource({ "0, 0", "1, 1", "9, 3", "625, 25", "1e10, 1e5"})
    @DisplayName("Sqrt Calculation Test")
    public void calcTest(double operand, double result) {
        final var sqrt = new Sqrt(operand);

        final var answer = sqrt.calc();

        Assertions.assertEquals(result, answer, EPS);
    }

}
