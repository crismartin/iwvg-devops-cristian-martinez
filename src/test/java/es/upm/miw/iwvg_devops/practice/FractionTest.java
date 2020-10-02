package es.upm.miw.iwvg_devops.practice;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FractionTest {
    int numerator = 1;
    int denominator = 2;
    private Fraction fraction;
    private Fraction otherFraction;
    private Fraction fractionInf;
    private Fraction fractionInd;

    @BeforeEach
    void before() {
        fraction = new Fraction(1, 2);
        otherFraction = new Fraction(5, 7);
        fractionInf = new Fraction(1, 0);
        fractionInd = new Fraction(0, 0);
    }

    @Test
    void testFractionIntInt() {
        assertEquals(numerator, fraction.getNumerator());
        assertEquals(denominator, fraction.getDenominator());
    }

    @Test
    void testFraction() {
        fraction = new Fraction();
        assertEquals(1, fraction.getNumerator());
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    void testSetNumerator() {
        int numerator = 10;
        fraction.setNumerator(numerator);
        assertEquals(numerator, fraction.getNumerator());
    }

    @Test
    void testSetDenominator() {
        int denominator = 10;
        fraction.setDenominator(denominator);
        assertEquals(denominator, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        double resultTest = (double) numerator / denominator;
        assertEquals(resultTest, fraction.decimal());
    }

    @Test
    void testDecimalInf() {
        double resultTest = Double.POSITIVE_INFINITY;
        assertEquals(resultTest, fractionInf.decimal());
    }

    @Test
    void testDecimalIndet() {
        double resultTest = Double.NaN;
        assertEquals(resultTest, fractionInd.decimal());
    }

    @Test
    void testIsProper() {
        boolean isProper = numerator < denominator;
        assertEquals(isProper, fraction.isProper());
    }

    @Test
    void testIsImproper() {
        boolean isImproper = numerator > denominator;
        assertEquals(isImproper, fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        boolean result = fraction.getNumerator() * otherFraction.getDenominator() == otherFraction.getNumerator() * fraction.getDenominator();
        assertEquals(result, fraction.isEquivalent(otherFraction));
    }

    @Test
    void testMultiply() {
        int resultNumerator = fraction.getNumerator() * otherFraction.getNumerator();
        int resultDenominator = fraction.getDenominator() * otherFraction.getDenominator();
        Fraction result = fraction.mutiply(otherFraction);
        assertEquals(resultNumerator, result.getNumerator());
        assertEquals(resultDenominator, result.getDenominator());
    }

    @Test
    void testDivide() {
        int resultNumerator = fraction.getNumerator() * otherFraction.getDenominator();
        int resultDenominator = fraction.getDenominator() * otherFraction.getNumerator();
        Fraction result = fraction.divide(otherFraction);
        assertEquals(resultNumerator, result.getNumerator());
        assertEquals(resultDenominator, result.getDenominator());
    }


    @Test
    void testAddNoEquiv() {
        Fraction resultExpected = new Fraction(17, 14);
        Fraction resultFunc = fraction.add(otherFraction);
        assertEquals(resultExpected.getNumerator(), resultFunc.getNumerator());
        assertEquals(resultExpected.getDenominator(), resultFunc.getDenominator());
    }

    @Test
    void testAddEquiv() {
        Fraction resultExpected = new Fraction(4, 4);
        int factor = 2;
        Fraction equivFraction = new Fraction(fraction.getNumerator() * factor, fraction.getDenominator() * factor);
        Fraction resultFunc = fraction.add(equivFraction);
        assertEquals(resultExpected.getNumerator(), resultFunc.getNumerator());
        assertEquals(resultExpected.getDenominator(), resultFunc.getDenominator());
    }

    @Test
    void testAddInf() {
        Fraction equivFraction = fraction.add(fractionInf);
        assertNull(equivFraction);
    }

    @Test
    void testAddIndet() {
        Fraction equivFraction = fraction.add(fractionInd);
        assertNull(equivFraction);
    }

    @Test
    void testToString() {
        String resultString = "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';

        assertEquals(resultString, fraction.toString());
    }

}
