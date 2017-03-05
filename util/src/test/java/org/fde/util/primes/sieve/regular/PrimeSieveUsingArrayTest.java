package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.sieve.PrimeSieve;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeSieveUsingArrayTest {
    @Test
    public void primeSieveUsingArrayTest() {
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
        return PrimeSieveFactory.createPrimeSieveUsingArray(10_000_000);
    }
}
