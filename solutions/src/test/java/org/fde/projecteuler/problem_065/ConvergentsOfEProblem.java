package org.fde.projecteuler.problem_065;

import org.junit.Test;

import java.math.BigInteger;

import static org.fde.projecteuler.problem_065.ConvergentsOfEProblem.NumberLong.numberLong;
import static org.fde.util.LeastCommonMultiple.lcm;

public class ConvergentsOfEProblem {
    static class NumberLong {
        final long n;
        final long d;

        public NumberLong(long numerator, long d) {
            this.n = numerator;
            this.d = d;
        }

        public NumberLong(long n) {
            this(n, 1);
        }

        static NumberLong numberLong(long n, long d) {
            return new NumberLong(n, d);
        }

        static NumberLong numberLong(long n) {
            return new NumberLong(n, 1);
        }

        NumberLong plus(NumberLong other) {
            long lcm = lcm(this.d, other.d);

            long x = (this.n * (lcm / this.d)) + (other.n * (lcm / other.d));
            return numberLong(x, lcm);
        }

        @Override
        public String toString() {
            return "Number{" +
                    "numerator=" + n +
                    ", denomitator=" + d +
                    '}';
        }

        static NumberLong ZERO = numberLong(0);
        static NumberLong ONE = numberLong(1);

        public NumberLong inverse() {
            return numberLong(this.d, this.n);
        }
    }

    static class NumberBigInteger {
        final BigInteger n;
        final BigInteger d;

        public NumberBigInteger(BigInteger numerator, BigInteger d) {
            this.n = numerator;
            this.d = d;
        }

        public NumberBigInteger(BigInteger n) {
            this(n, BigInteger.ONE);
        }

        static NumberBigInteger numberBigInteger(BigInteger n, BigInteger d) {
            return new NumberBigInteger(n, d);
        }

        static NumberBigInteger numberBigInteger(BigInteger n) {
            return new NumberBigInteger(n, BigInteger.ONE);
        }

        NumberBigInteger plus(NumberBigInteger other) {
            BigInteger lcm = lcm(this.d, other.d);

            BigInteger x = (this.n.multiply(lcm).divide(this.d)).add((other.n.multiply(lcm).divide(other.d)));
            return numberBigInteger(x, lcm);
        }

        @Override
        public String toString() {
            return "Number{" +
                    "numerator=" + n +
                    ", denomitator=" + d +
                    '}';
        }

        static NumberBigInteger ZERO = numberBigInteger(BigInteger.ZERO);
        static NumberBigInteger ONE = numberBigInteger(BigInteger.ONE);

        public NumberBigInteger inverse() {
            return numberBigInteger(this.d, this.n);
        }
    }

    @Test
    public void testWithLong () {
        NumberLong result = NumberLong.ZERO;

        for (int k = 99; k >= 0; --k) {
            long factor = factorLong(k);

            result = NumberLong.numberLong(factor).plus(result);

            if (k > 0) {
                result = result.inverse();
            }
        }

        System.out.println("result = " + result);
    }

    @Test
    public void testWithBigInteger () {
        NumberBigInteger result = NumberBigInteger.ZERO;

        for (int k = 99; k >= 0; --k) {
            BigInteger factor = BigInteger.valueOf(factorLong(k));

            result = NumberBigInteger.numberBigInteger(factor).plus(result);

            if (k > 0) {
                result = result.inverse();
            }
        }

        System.out.println("result = " + result);
    }

    private long factorLong(int j) {
        if (j == 0) {
            return 2;
        }

        if (j == 1) {
            return 1;
        }

        int i = j - 2;

        if ((i % 3) == 0) {
            long x = (i / 3) + 1;
            long factor = 2 * x;
            return factor;
        }
        else {
            return 1;
        }
    }
}
