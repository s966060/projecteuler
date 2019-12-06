package org.fde.projecteuler.problem_064;

import org.junit.Test;

import java.math.BigDecimal;

public class SquareRoots {
    static class X {
        final double value;
        final BigDecimal asBigDecimal;

        public X(double value) {
            this.value = value;
            this.asBigDecimal = java.math.BigDecimal.valueOf(value);
        }

        public X(double value, BigDecimal asBigDecimal) {
            this.value = value;
            this.asBigDecimal = asBigDecimal;
        }

        String toHexString() {
            return Double.toHexString(this.value);
        }

        @Override
        public String toString() {
            return "X{" +
                    "value=" + this.value + "  ---  " + Double.toHexString(value) + " --- " + this.asBigDecimal +
                    '}';
        }

        static X valueOf(double value) {
            return new X(value);
        }

        X plus (X other) {
            double newValue = this.value + other.value;
            BigDecimal newAsBigDecimal = this.asBigDecimal.add(other.asBigDecimal);
            X newX = new X(newValue, newAsBigDecimal);
            return newX;
        }

        X divide(X other) {
            double newValue = this.value / other.value;
            BigDecimal newAsBigDecimal = this.asBigDecimal.divide(other.asBigDecimal, 100, BigDecimal.ROUND_HALF_UP);
            X newX = new X(newValue, newAsBigDecimal);
            return newX;
        }

        X multiply(X other) {
            double newValue = this.value * other.value;
            BigDecimal newAsBigDecimal = this.asBigDecimal.multiply(other.asBigDecimal);
            X newX = new X(newValue, newAsBigDecimal);
            return newX;
        }

        X mathSquareRoot() {
            X newValue = X.valueOf(Math.sqrt(this.value));
            return newValue;
        }
    }

    @Test
    public void f() {
        X target = X.valueOf(2);
        X estimate = X.valueOf(1);

        for (int n = 1; n < 20; ++n) {
            estimate = X.valueOf(0.5).multiply(( estimate.plus (target.divide(estimate))));
            System.out.println("estimate = " + estimate);
        }

        X  exactSquareRoot = target.mathSquareRoot();
        System.out.println("exactSquareRoot = " + exactSquareRoot);

    }
}
