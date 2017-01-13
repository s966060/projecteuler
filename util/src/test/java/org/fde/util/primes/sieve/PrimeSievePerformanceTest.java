package org.fde.util.primes.sieve;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class PrimeSievePerformanceTest {
    @Test
    public void upTo_1_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieve sieve = new PrimeSieve(1_000_000);
        sieve.sieve();

        // about 20 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void upTo_10_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieve sieve = new PrimeSieve(10_000_000);
        sieve.sieve();

        // about 90 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void upTo_100_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieve sieve = new PrimeSieve(100_000_000);
        sieve.sieve();

        // about 2 seconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }
}