package org.fde.projecteuler.problem_065;

import org.junit.Test;

import static org.fde.projecteuler.problem_065.ConvergentsOfEProblem.Number.number;
import static org.fde.util.LeastCommonMultiple.lcm;

public class ConvergentsOfEProblem {
    static class Number {
        final long n;
        final long d;

        public Number(long numerator, long d) {
            this.n = numerator;
            this.d = d;
        }

        public Number(long n) {
            this(n, 1);
        }

        static Number number(long n, long d) {
            return new Number(n, d);
        }

        static Number number(long n) {
            return new Number(n, 1);
        }

        Number plus(Number other) {
            long lcm = lcm(this.d, other.d);

            long x = (this.n * (lcm / this.d)) + (other.n * (lcm / other.d));
            return number(x, lcm);
        }

        @Override
        public String toString() {
            return "Number{" +
                    "numerator=" + n +
                    ", denomitator=" + d +
                    '}';
        }

        static Number ZERO = number(0);
        static Number ONE = number(1);

        public Number inverse() {
            return number(this.d, this.n);
        }
    }

    @Test
    public void f () {
        Number result = Number.ZERO;

        for (int k = 99; k >= 0; --k) {
            long factor = factor(k);

            result = number(factor).plus(result);

            if (k > 0) {
                result = result.inverse();
            }
        }

        System.out.println("result = " + result);
    }

    private long factor(int j) {
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
