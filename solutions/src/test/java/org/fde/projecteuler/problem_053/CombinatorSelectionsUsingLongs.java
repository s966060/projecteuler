package org.fde.projecteuler.problem_053;

import org.fde.util.ListOfLong;
import org.fde.util.LongUtil;
import org.fde.util.primes.PrimeFactors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombinatorSelectionsUsingLongs {

    public static final int LIMIT = 1_000_000;

    @Test
    public void combinatorSelections() {
        int count = 0;

        for (int n = 1; n <= 100; ++n) {
            int midpoint = n / 2;
            boolean overAMillion = false;

            int r = 0;

            while (r <= midpoint && !overAMillion) {
                long result = combination(n, r);
                // System.out.printf("result = C(%s, %s) = %s%n", n, r, result);

                if (result > LIMIT) {
                    overAMillion = true;
                } else {
                    ++r;
                }
            }

            if (overAMillion) {
                count += (midpoint - r) * 2; // all except the mid points
                count += LongUtil.isEven(n) ? 1 : 2;
                // System.out.println("count = " + count);
            }
        }

        System.out.println("!!! count = " + count);
        assertEquals(4075, count);
    }

    private long combination(int n, int r) {
        ListOfLong nFactors = factorial(n);
        ListOfLong rFactors = factorial(r);
        ListOfLong nMinusRFactors = factorial(n - r);

        nFactors.remove(rFactors);
        nFactors.remove(nMinusRFactors);

        long result = 1;

        for (long factor : nFactors) {
            result *= factor;

            if (result > LIMIT) {
                return Long.MAX_VALUE;
            }
        }

        return result;
    }

    private final PrimeFactors primeFactors = new PrimeFactors();

    private ListOfLong factorial(int n) {
        ListOfLong allFactors = new ListOfLong();

        for (int i = 1; i <= n; ++i) {
            ListOfLong factors = primeFactors.getPrimeFactors(i);
            allFactors.addAll(factors);
        }

        return allFactors;
    }
}
