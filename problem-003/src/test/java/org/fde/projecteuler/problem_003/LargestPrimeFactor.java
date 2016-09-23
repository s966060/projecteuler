package org.fde.projecteuler.problem_003;

import org.fde.util.ListOfLong;
import org.fde.util.Logger;
import org.fde.util.primes.PrimeFactors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargestPrimeFactor {
    @Test
    public void largestPrimeFactor() {
        long actual = findPrimeFactors(600_851_475_143L);
        assertEquals(6857, actual);
    }

    private long findPrimeFactors(long target) {
        final long TARGET = target;

        ListOfLong factors = new PrimeFactors().getPrimeFactors(target);

        Logger.log("factors = " + factors);

        target = 1;

        for (Long factor : factors) {
            target *= factor;
        }

        if (target != TARGET) {
            throw new IllegalArgumentException("factorization failure");
        }

        return factors.last();
    }
}
