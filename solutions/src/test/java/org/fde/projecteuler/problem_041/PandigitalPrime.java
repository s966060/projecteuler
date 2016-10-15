package org.fde.projecteuler.problem_041;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.LongUtil;
import org.fde.util.primes.IsPrime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PandigitalPrime {
    @Test
    public void pandigitalPrime() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Long target = null;

        IsPrime isPrime = new IsPrime();

        for (long suspect = 987_654_321; suspect >= 100_000_000; --suspect) {
            if (suspect % 1_000_000 == 0) {
                System.out.println("stopWatch = " + stopWatch);
                System.out.println("suspect = " + suspect);
            }

            if (isPrime.isPrime(suspect)) {
                if (LongUtil.isPandigital(suspect)) {
                    target = suspect;
                    break;
                }
            }
        }

        System.out.println("stopWatch = " + stopWatch);
        assertEquals(987_654_321L, target.longValue());
    }
}
