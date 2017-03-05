package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.regular.PrimeSieveUsingBitSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeSieveUsingBitSetTest {
    @Test
    public void primeSieveUsingBitSetTest() {
        PrimeSieve sieve = createPrimeSieve(10_000_000);
        sieve.sieve();

        PrimeBuilder builder = new PrimeBuilder();

        int count = 0;

        for (Long prime : sieve.getPrimes()) {
            long expected = builder.next();
            assertEquals(expected, prime.longValue());
            ++count;
        }

        assertEquals(664579, count);
    }

    private PrimeSieve createPrimeSieve(int upTo) {
        return new PrimeSieveUsingBitSet(10_000_000);
    }
}
