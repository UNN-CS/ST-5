package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SqrtTest {

    @Test
    void averageOfTwoAndFourIsThree() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(3.0, sqrt.average(2.0, 4.0), 1e-15);
    }

    @Test
    void averageOfEqualValuesIsUnchanged() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(7.5, sqrt.average(7.5, 7.5), 1e-15);
    }

    @Test
    void goodIsTrueWhenGuessSquaredMatchesXWithinDelta() {
        Sqrt sqrt = new Sqrt(1);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void goodIsFalseWhenGuessIsFarFromSquareRoot() {
        Sqrt sqrt = new Sqrt(1);
        assertFalse(sqrt.good(1.0, 100.0));
    }

    @Test
    void improveWithPerfectGuessLeavesTwoForFour() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(2.0, sqrt.improve(2.0, 4.0), 1e-15);
    }

    @Test
    void improveRefinesRoughGuessTowardRoot() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 1e-15);
    }

    @Test
    void iterReturnsGuessImmediatelyWhenAlreadyGood() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(3.0, sqrt.iter(3.0, 9.0), 1e-15);
    }

    @Test
    void iterConvergesFromInitialGuessForSquare() {
        Sqrt sqrt = new Sqrt(1);
        assertEquals(2.0, sqrt.iter(1.0, 4.0), 1e-9);
    }

    @Test
    void calcReturnsTwoForFour() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), 1e-9);
    }

    @Test
    void calcReturnsThreeForNine() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(Math.sqrt(9.0), sqrt.calc(), 1e-8);
    }

    @Test
    void calcMatchesMathSqrtForTwo() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-8);
    }

    @Test
    void calcUsesConstructorArgument() {
        Sqrt sqrt = new Sqrt(25.0);
        assertEquals(5.0, sqrt.calc(), 1e-9);
    }
}
