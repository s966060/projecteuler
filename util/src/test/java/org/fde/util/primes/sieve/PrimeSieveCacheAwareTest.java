package org.fde.util.primes.sieve;

import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeSieveCacheAwareTest {
    @Test
    public void primeSieveCacheAwareTest() {
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
        return new PrimeSieveUsingArray(upTo);
    }
}
