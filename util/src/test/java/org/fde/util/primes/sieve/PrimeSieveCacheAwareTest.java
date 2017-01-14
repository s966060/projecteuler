package org.fde.util.primes.sieve;

import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeSieveCacheAwareTest {
    @Test
    public void primeSieveTest() {
        PrimeSieveCacheAware sieve = new PrimeSieveCacheAware(1_000_000);
        sieve.sieve();

        PrimeBuilder builder = new PrimeBuilder();

        for (Long prime : sieve.getPrimes()) {
            assertEquals(builder.next(), prime.longValue());
        }
    }
}
