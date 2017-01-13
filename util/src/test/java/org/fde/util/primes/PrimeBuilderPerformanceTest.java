package org.fde.util.primes;

import org.junit.Test;
import org.apache.commons.lang3.time.StopWatch;

import static org.junit.Assert.assertEquals;

public class PrimeBuilderPerformanceTest {
    @Test
    public void upToOneMillion() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeBuilder builder = new PrimeBuilder();

        while(builder.next() < 1_000_000);

        assertEquals(1_000_003L, builder.current());

        // about 200 milliseconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }

    @Test
    public void upToTenMillion() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        PrimeBuilder builder = new PrimeBuilder();

        while(builder.next() < 10_000_000);

        assertEquals(10_000_019L, builder.current());

        // about 3.5 seconds on my iCore 7 3770
        System.out.println("stopWatch = " + stopWatch);
    }
}
