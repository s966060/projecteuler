package org.fde.util.primes;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeBuilderPerformanceTest {
    @Test
    public void upToOneMillion() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeBuilder builder = new PrimeBuilder();

        while(builder.next() < 1_000_000);

        // about 200 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);

        assertEquals(1_000_003L, builder.current());
    }

    @Test
    public void upToTenMillion() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeBuilder builder = new PrimeBuilder();

        while(builder.next() < 10_000_000);

        // about 3.5 seconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);

        assertEquals(10_000_019L, builder.current());
    }

    @Ignore("Too slow - provide a better implementation")
    @Test
    public void upToHundredMillion() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeBuilder builder = new PrimeBuilder();

        while(builder.next() < 100_000_000);

        // about 1.5 minute on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);

        assertEquals(100_000_007L, builder.current());
    }
}
