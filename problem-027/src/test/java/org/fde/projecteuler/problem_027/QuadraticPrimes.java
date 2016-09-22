package org.fde.projecteuler.problem_027;

import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuadraticPrimes {

    @Test
    public void quadraticPrimes() {
        PrimeBuilder builder = new PrimeBuilder();

        int largestN = 0;
        QuadraticFormula target = null;

        for (int a = -999; a < 1000; ++a) {
            for (int b = -1000; b <= 1000; ++b) {
                QuadraticFormula formula = new QuadraticFormula(a, b);

                if (formula.evaluate(0) < 2) {
                    continue;
                }

                formula.setPrimeBuilder(builder);
                int n = formula.evaluate(null);

                if(n > largestN) {
                    largestN = n;
                    target = formula;
                }
            }
        }

        System.out.println("largestN = " + largestN);
        System.out.println("target = " + target);
        target.evaluate(System.out);

        int expected = -61 * 971;
        int actual = target.getA() * target.getB();
        assertEquals(expected, actual);
    }
}
