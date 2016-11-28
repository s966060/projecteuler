package org.fde.projecteuler.problem_051.optimized;

import javafx.scene.paint.Stop;
import org.apache.commons.lang3.time.StopWatch;
import org.fde.projecteuler.problem_051.Replace;
import org.fde.projecteuler.problem_051.ReplaceFamily;
import org.fde.projecteuler.problem_051.ReplaceIterator;
import org.fde.util.Digits;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class OptimizedPrimeDigitReplacements {

    public static final int LOG_THRESHOLD = 1_000;

    @Test
    public void primeDigitReplacements() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Primes primes = new Primes();
        ReplaceFamily replaceFamily = ReplaceFamily._null_(0);

        long logThreshold = LOG_THRESHOLD;

        for (int canonicalSuspect = 1; replaceFamily.getFamily() < 8; ++canonicalSuspect) {
            replaceFamily = getReplaceFamily(primes, 2, canonicalSuspect, 8);

            if (canonicalSuspect > logThreshold) {
                System.out.println(stopWatch + " log ... " + canonicalSuspect);
                logThreshold += LOG_THRESHOLD;
            }
        }

        System.out.println("!!! replaceFamily = " + replaceFamily);
    }

    @Test
    public void primeDigitReplacements_1_3() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 1, 3, 6);

        assertEquals(6, replaceFamily.getFamily());
        assertEquals(3, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{0}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_563() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 563, 7);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(563, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 3}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_7991() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 7991, 7);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(7991, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{1, 4}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_76399() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 76399, 7);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(76399, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 5}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_995369() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 995369, 7);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(995369, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 5}, replaceFamily.getReplaceIndexes());
    }

    private ReplaceFamily getReplaceFamily(Primes primes, int replaceCount, long canonicalSuspect, int targetFamily) {
        ReplaceFamily globalReplaceFamily = ReplaceFamily._null_(canonicalSuspect);

        Digits canonicalSuspectAsDigits = Digits.valueOf(canonicalSuspect);

        ReplaceIterator it = new ReplaceIterator(new OptimizedReplaceFactory(targetFamily), replaceCount, canonicalSuspectAsDigits.size());

        while (it.hasNext()) {
            Replace replace = it.next();

            if(it.isLastIteratorOnTheLastDigit()) {
                continue;
            }

            int familyCounter = replace.getFamily(primes, canonicalSuspectAsDigits);

            if (familyCounter > globalReplaceFamily.getFamily()) {
                globalReplaceFamily = new ReplaceFamily(canonicalSuspect,
                        it.getReplaceIndexes(), familyCounter);
            }
        }

        return globalReplaceFamily;
    }
}