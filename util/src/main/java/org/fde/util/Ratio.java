package org.fde.util;

import org.fde.util.primes.PrimeFactors;

public class Ratio {
    private final int nominator;
    private final int denominator;

    public Ratio(int nominator, int denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public Ratio add(Ratio other) {
        return new Ratio(
                this.nominator * other.denominator + other.nominator * this.denominator,
                this.denominator * other.denominator);
    }

    public Ratio mul(Ratio other) {
        return new Ratio(
                this.nominator * other.nominator,
                this.denominator * other.denominator);
    }

    public Ratio div(Ratio other) {
        return new Ratio(
                this.nominator * other.denominator,
                this.denominator * other.nominator);
    }

    public Ratio simplify() {
        ListOfLong commonFactors = getCommonFactors();

        int newNominator = this.nominator;
        int newDecnominator = this.denominator;

        for (Long factor : commonFactors) {
            newNominator /= factor;
            newDecnominator /= factor;
        }

        return new Ratio(newNominator, newDecnominator);
    }

    private ListOfLong getCommonFactors() {
        PrimeFactors factors = new PrimeFactors();

        ListOfLong nominatorFactors = factors.getPrimeFactors(this.nominator);
        ListOfLong denominatorFactors = factors.getPrimeFactors(this.denominator);

        return nominatorFactors.getIntersection(denominatorFactors);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ratio ratio = (Ratio) o;

        if (nominator != ratio.nominator) return false;
        return denominator == ratio.denominator;
    }

    @Override
    public int hashCode() {
        int result = nominator;
        result = 31 * result + denominator;
        return result;
    }
}
