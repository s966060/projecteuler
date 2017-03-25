package org.fde.util.primes.sieve;

import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fde.util.primes.sieve.cache_aware.PrimeSieveCacheAwareFactory.*;
import static org.fde.util.primes.sieve.regular.PrimeSieveRegularFactory.createPrimeSieveUsingArray;
import static org.fde.util.primes.sieve.regular.PrimeSieveRegularFactory.createPrimeSieveUsingBitSet;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimeSieveTest {
    @Parameterized.Parameters(name = "{index}: sieve({0})")
    public static Collection<PrimeSieve> sieveAlgorithms() {
        int size = 10_000_000;

        PrimeSieve[] algorithms = {
                createPrimeSieveUsingArray(size),
                createPrimeSieveUsingBitSet(size),
                createPrimeSieveCacheAwareUsingArray(size),
                createPrimeSieveCacheAwareUsingBitSet(size),
                createPrimeSieveCacheAwareUsingMultiBitSet(size)};

        return Arrays.asList(algorithms);
    }

    @Parameterized.Parameter
    public PrimeSieve sieve;

    @Test
    public void primeSieveTest() {
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
}
