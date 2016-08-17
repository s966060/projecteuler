package org.fde.problem_003;

import org.fde.util.primes.PrimeFactors;

import java.util.List;

public class LargestPrimeFactor {
    public static void main(String[] args) {
        findPrimeFactors(600_851_475_143L);
        findPrimeFactors(1024 * 1024 * 1024);
        findPrimeFactors(13);
        findPrimeFactors(1_082_801);
    }

    private static void findPrimeFactors(long target) {
        final long TARGET = target;

        List<Long> factors = new PrimeFactors().getPrimeFactors(target);

        System.out.println("factors = " + factors);

        target = 1;

        for (Long factor : factors) {
            target *= factor;
        }

        System.out.println("target = " + target);
        System.out.println("TARGET = " + TARGET);

        if (target != TARGET) {
            throw new IllegalArgumentException("factorization failure");
        }
    }

}
