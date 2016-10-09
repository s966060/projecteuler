package org.fde.projecteuler.problem_035;

import org.fde.util.ListOfLong;
import org.fde.util.LongUtil;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircularPrimes {
    @Test
    public void circularPrimes() {
        int count = 0;

        Primes primeContainer = new Primes();
        PrimeBuilder primeGenerator = new PrimeBuilder(primeContainer);
        PrimeBuilder primeEvaluator = new PrimeBuilder(primeContainer);

        long prime;

        nextPrime:
        while ((prime = primeGenerator.next()) < 1_000_000) {
            ListOfLong possiblePrimeValues = LongUtil.getRotatedValues(prime);

            for (Long suspect : possiblePrimeValues) {
                if (!primeEvaluator.isPrime(suspect)) {
                    continue nextPrime;
                }
            }

            System.out.println("possiblePrimeValues = " + possiblePrimeValues);
            ++count;
        }

        assertEquals(55, count);
    }
}
