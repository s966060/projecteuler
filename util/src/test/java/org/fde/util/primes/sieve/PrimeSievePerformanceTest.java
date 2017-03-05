package org.fde.util.primes.sieve;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.primes.sieve.PrimeSieve;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.fde.util.primes.sieve.cache_aware.PrimeSieveCacheAwareFactory.createPrimeSieveCacheAwareUsingArray;
import static org.fde.util.primes.sieve.cache_aware.PrimeSieveCacheAwareFactory.createPrimeSieveCacheAwareUsingBitSet;
import static org.fde.util.primes.sieve.regular.PrimeSieveRegularFactory.createPrimeSieveUsingArray;
import static org.fde.util.primes.sieve.regular.PrimeSieveRegularFactory.createPrimeSieveUsingBitSet;

@RunWith(Parameterized.class)
public class PrimeSievePerformanceTest {
    @Parameterized.Parameters(name = "{index}: run({0})")
    public static Collection<PrimeSieve> sieveAlgorithms() {
        int[] sizes = {1_000_000, 10_000_000, 100_000_000};

        List<PrimeSieve> runs = new ArrayList<>();

        for (int size : sizes) {
            runs.add(createPrimeSieveUsingArray(size));
            runs.add(createPrimeSieveUsingBitSet(size));
            runs.add(createPrimeSieveCacheAwareUsingArray(size));
            runs.add(createPrimeSieveCacheAwareUsingBitSet(size));
        }

        return runs;
    }

    @Parameterized.Parameter
    public PrimeSieve sieve;

    @Test
    public void primeSievePerformanceTest() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        sieve.sieve();

        // about 5 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }
}
