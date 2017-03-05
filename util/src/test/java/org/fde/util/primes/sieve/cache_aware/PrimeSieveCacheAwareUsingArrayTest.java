package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.regular.PrimeSieveFactory;
import org.junit.Test;

import static org.fde.util.primes.sieve.regular.PrimeSieveFactory.createPrimeSieveUsingArray;
import static org.junit.Assert.assertEquals;

public class PrimeSieveCacheAwareUsingArrayTest {
    @Test
    public void primeSieveCacheAwareUsingArrayTest() {
        PrimeSieve sieve = createPrimeSieve(10_000_000);
        sieve.sieve();

        PrimeBuilder builder = new PrimeBuilder();

        int count = 0;
        long lastComputePrime = 0;

        for (Long prime : sieve.getPrimes()) {
            long expected = builder.next();
            lastComputePrime = prime;
            assertEquals(expected, lastComputePrime);
            ++count;
        }

        assertEquals(664_579, count);
        assertEquals(9_999_991, lastComputePrime);
    }

    private PrimeSieve createPrimeSieve(int upTo) {
        return createPrimeSieveUsingArray(upTo);
    }
}
