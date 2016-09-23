package org.fde.projecteuler.problem_003;

import org.fde.util.ListOfLong;
import org.fde.util.Logger;
import org.fde.util.primes.PrimeFactors;

public class LargestPrimeFactor {
    public static void main(String[] args) {
        findPrimeFactors(600_851_475_143L);
        findPrimeFactors(1024 * 1024 * 1024);
        findPrimeFactors(13);
        findPrimeFactors(1_082_801);
    }

    private static void findPrimeFactors(long target) {
        final long TARGET = target;

        ListOfLong factors = new PrimeFactors().getPrimeFactors(target);

        Logger.log("factors = " + factors);

        target = 1;

        for (Long factor : factors) {
            target *= factor;
        }

        Logger.log("target = " + target);
        Logger.log("TARGET = " + TARGET);

        if (target != TARGET) {
            throw new IllegalArgumentException("factorization failure");
        }
    }

}
