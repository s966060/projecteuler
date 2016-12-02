package org.fde.projecteuler.problem_053;

import org.fde.util.LongUtil;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class CombinatorSelections {
    @Test
    public void combinatorSelections() {
        int count = 0;

        for (int n = 1; n <= 100; ++n) {
            int midpoint = n / 2;
            boolean overAMillion = false;

            int r = 0;

            while (r <= midpoint && !overAMillion) {
                BigInteger result = combination(n, r);
                // System.out.printf("result = C(%s, %s) = %s%n", n, r, result);

                if (result.compareTo(BigInteger.valueOf(1_000_000)) > 0) {
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

    private BigInteger combination(int n, int r) {
        BigInteger result = factorial(n).divide(factorial(r)).divide(factorial(n - r));
        return result;
    }

    private BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }

        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= n; ++i) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
