package org.fde.util.primes.sieve;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class PrimeSieveUsingArrayPerformanceTest {
    @Test
    public void A_upTo_A_1_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieve sieve = new PrimeSieveUsingArray(1_000_000);
        sieve.sieve();

        // about 5 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void B_upTo_B_10_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieve sieve = new PrimeSieveUsingArray(10_000_000);
        sieve.sieve();

        // about 50 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void C_upTo_C_100_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieve sieve = new PrimeSieveUsingArray(100_000_000);
        sieve.sieve();

        // about 1 second on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void D_upTo_D_1000_Million() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeSieve sieve = new PrimeSieveUsingArray(1_000_000_000);
        sieve.sieve();

        // about 11.5seconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }
}
