package org.fde.projecteuler.problem_037;

import org.fde.util.ListOfLong;
import org.fde.util.LongUtil;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TruncatablePrimes {
    @Test
    public void truncatablePrimes() {
        Primes primes = new Primes();
        PrimeBuilder generator = new PrimeBuilder(primes);
        PrimeBuilder validator = new PrimeBuilder(primes);

        long sum = 0;
        int count = 0;

        nextPrime:
        while (count < 11) {
            long prime = generator.next();

            if(prime < 10) {
                continue nextPrime;
            }

            ListOfLong leftSuspects = LongUtil.getTruncatedLeftValues(prime);

            for (Long suspect : leftSuspects) {
                if (!validator.isPrime(suspect)) {
                    continue nextPrime;
                }
            }

            ListOfLong rightSuspects = LongUtil.getTruncatedRightValues(prime);

            for (Long suspect : rightSuspects) {
                if (!validator.isPrime(suspect)) {
                    continue nextPrime;
                }
            }

            System.out.println("prime = " + prime);
            System.out.println("leftSuspects = " + leftSuspects);
            System.out.println("rightSuspects = " + rightSuspects);
            ++count;
            sum += prime;
        }

        System.out.println("sum = " + sum);
        assertEquals(748317, sum);
    }
}
