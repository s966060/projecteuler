package org.fde.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RatioOfBigInteger {
    private final BigInteger nominator;
    private final BigInteger denominator;

    public RatioOfBigInteger(long nominator, long denominator) {
        this.nominator = BigInteger.valueOf(nominator);
        this.denominator = BigInteger.valueOf(denominator);
    }

    public RatioOfBigInteger(long nominator) {
        this(nominator, 1);
    }

    public RatioOfBigInteger(BigInteger nominator, BigInteger denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public RatioOfBigInteger add(RatioOfBigInteger other) {
        BigInteger newNominator = (this.nominator.multiply(other.denominator)).
                add(other.nominator.multiply(this.denominator));

        BigInteger newDenominator = this.denominator.multiply(other.denominator);

        return new RatioOfBigInteger(newNominator, newDenominator);
    }

    public RatioOfBigInteger mul(RatioOfBigInteger other) {
        BigInteger newNominator = this.nominator.multiply(other.nominator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);

        return new RatioOfBigInteger(newNominator, newDenominator);
    }

    public RatioOfBigInteger div(RatioOfBigInteger other) {
        BigInteger newNominator = this.nominator.multiply(other.denominator);
        BigInteger newDenominator = this.denominator.multiply(other.nominator);

        return new RatioOfBigInteger(newNominator, newDenominator);
    }

    public RatioOfBigInteger simplify() {
        BigInteger newNominator = this.nominator;
        BigInteger newDenominator = this.denominator;

        BigInteger gcd = newNominator.gcd(newDenominator);

        while (!gcd.equals(BigInteger.ONE)) {
            newNominator = newNominator.divide(gcd);
            newDenominator = newDenominator.divide(gcd);

            gcd = newNominator.gcd(newDenominator);
        }

        return new RatioOfBigInteger(newNominator, newDenominator);
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public BigInteger getNominator() {
        return nominator;
    }

    public double getRatioAsDouble() {
        double ratio = nominator.doubleValue() / denominator.doubleValue();
        return ratio;
    }

    @Override
    public String toString() {
        return "RatioOfBigInteger{" +
                "nominator=" + nominator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RatioOfBigInteger that = (RatioOfBigInteger) o;

        if (!nominator.equals(that.nominator)) return false;
        return denominator.equals(that.denominator);
    }

    @Override
    public int hashCode() {
        int result = nominator.hashCode();
        result = 31 * result + denominator.hashCode();
        return result;
    }
}
