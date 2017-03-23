package org.fde.util.primes.sieve;

import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fde.util.primes.sieve.cache_aware.PrimeSieveCacheAwareFactory.createPrimeSieveCacheAwareUsingArray;
import static org.fde.util.primes.sieve.cache_aware.PrimeSieveCacheAwareFactory.createPrimeSieveCacheAwareUsingBitSet;
import static org.fde.util.primes.sieve.regular.PrimeSieveRegularFactory.createPrimeSieveUsingArray;
import static org.fde.util.primes.sieve.regular.PrimeSieveRegularFactory.createPrimeSieveUsingBitSet;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CalculatePrimeTest {
    @Parameterized.Parameters(name = "{index}: sieve({0})")
    public static Collection<PrimeSieve> sieveAlgorithms() {
        int size = 10_000;

        PrimeSieve[] algorithms = {
                createPrimeSieveUsingArray(size),
                createPrimeSieveUsingBitSet(size),
                createPrimeSieveCacheAwareUsingArray(size),
                createPrimeSieveCacheAwareUsingBitSet(size)};

        return Arrays.asList(algorithms);
    }

    @Parameterized.Parameter
    public PrimeSieve sieve;

    @Test
    public void calculatePrimeTest() {
        this.sieve.sieve();

        PrimeBuilder builder = new PrimeBuilder();

        for(int suspect = 0; suspect <= 994_009; ++suspect) {
            boolean expected = builder.isPrime(suspect);
            boolean actual = this.sieve.isPrime(suspect);

            assertEquals(
                    String.format("suspect(%s) expected (%s) actual(%s)",
                                                    suspect, actual, expected),
                    expected, actual);
        }
    }
}
