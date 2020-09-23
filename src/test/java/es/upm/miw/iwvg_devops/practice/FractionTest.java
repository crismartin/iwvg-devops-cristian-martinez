package es.upm.miw.iwvg_devops.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    int numerator = 1;
    int denominator = 2;
    private Fraction fraction;
    private Fraction otherFraction;

    @BeforeEach
    void before() {
        fraction = new Fraction(1, 2);
        otherFraction = new Fraction(5, 7);
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
    void testIsProper(){
        boolean isProper = numerator < denominator;
        assertEquals(isProper, fraction.isProper());
    }

    @Test
    void testIsIproper(){
        boolean isImproper = numerator > denominator;
        assertEquals(isImproper, fraction.isImproper());
    }

    @Test
    void testMultiply(){
        double resultAuxTest = (double) fraction.getNumerator() * otherFraction.getNumerator() / fraction.getDenominator() * otherFraction.getDenominator();
        double resultMultiply = fraction.mutiply(otherFraction);
        assertEquals(resultAuxTest, resultMultiply);
    }

    @Test
    void testDivide(){
        double resultAuxTest = (double) fraction.getNumerator() * otherFraction.getDenominator() / fraction.getDenominator() * otherFraction.getNumerator();
        double resultMultiply = fraction.divide(otherFraction);
        assertEquals(resultAuxTest, resultMultiply);
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