package org.fde.util.primes.sieve;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class PrimeSieveCacheAwarePerformanceTest {
    @Test
    public void A_upTo_A_1_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieveCacheAware sieve = new PrimeSieveCacheAware(1_000_000);
        sieve.sieve();

        // about 20 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void B_upTo_B_10_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieveCacheAware sieve = new PrimeSieveCacheAware(10_000_000);
        sieve.sieve();

        // about 90 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void C_upTo_C_100_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieveCacheAware sieve = new PrimeSieveCacheAware(100_000_000);
        sieve.sieve();

        // about 2 seconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void D_upTo_D_1000_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieveCacheAware sieve = new PrimeSieveCacheAware(1_000_000_000);
        sieve.sieve();

        // about 11.5 seconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }
}
