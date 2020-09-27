package es.upm.miw.iwvg_devops.practice;


/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return numerator < denominator;
    }

    public boolean isImproper() {
        return !this.isProper();
    }

    public boolean isEquivalent(Fraction otherFraction) {
        assert this.denominator != 0 && otherFraction != null && otherFraction.denominator != 0;
        return (this.numerator * otherFraction.denominator == otherFraction.numerator * this.denominator);
    }

    public Fraction mutiply(Fraction otherFraction) {
        assert this.denominator != 0 && otherFraction != null && otherFraction.denominator != 0;
        int multiplyNumerators = this.numerator * otherFraction.numerator;
        int multiplyDenominators = this.denominator * otherFraction.denominator;
        return new Fraction(multiplyNumerators, multiplyDenominators);
    }

    private Fraction invert() {
        return new Fraction(this.denominator, this.numerator);
    }

    public Fraction divide(Fraction otherFraction) {
        return mutiply(otherFraction.invert());
    }

    private static int restBetweenNums(int numA, int numB) {

        int gt = Math.max(numA, numB);
        int lt = Math.min(numA, numB);

        return gt % lt;
    }

    private static int lcm(Fraction fractionA, Fraction fractionB) {
        int result;
        assert fractionA != null && fractionA.denominator != 0 && fractionB != null && fractionB.denominator != 0;

        if (fractionA.isEquivalent(fractionB) || restBetweenNums(fractionA.denominator, fractionB.denominator) == 0) {
            result = Math.max(fractionA.denominator, fractionB.denominator);
        } else {
            result = fractionA.denominator * fractionB.denominator;
        }

        return result;
    }

    public Fraction add(Fraction otherFraction) {
        Fraction result = new Fraction();
        int lcm;
        int numeratorResult;
        assert this.denominator != 0 && otherFraction != null && otherFraction.denominator != 0;

        lcm = lcm(this, otherFraction);
        numeratorResult = this.numerator * (lcm / this.denominator) + otherFraction.numerator * (lcm / otherFraction.denominator);
        result.setNumerator(numeratorResult);
        result.setDenominator(lcm);

        return result;
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}

