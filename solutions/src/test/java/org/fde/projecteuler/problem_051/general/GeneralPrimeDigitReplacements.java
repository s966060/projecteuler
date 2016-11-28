package org.fde.projecteuler.problem_051.general;

import org.fde.projecteuler.problem_051.Replace;
import org.fde.projecteuler.problem_051.ReplaceFamily;
import org.fde.projecteuler.problem_051.ReplaceIterator;
import org.fde.util.Digits;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GeneralPrimeDigitReplacements {

    public static final int LOG_THRESHOLD = 1_000;

    @Test
    public void primeDigitReplacements() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = ReplaceFamily._null_(0);

        long logThreshold = LOG_THRESHOLD;

        for (int canonicalSuspect = 1; replaceFamily.getFamily() < 8; ++canonicalSuspect) {
            replaceFamily = getReplaceFamily(primes, 2, canonicalSuspect);

            if (replaceFamily.getFamily() >= 7) {
                System.out.println("replaceFamily = " + replaceFamily);
            }

            if (canonicalSuspect > logThreshold) {
                System.out.println("log ... " + canonicalSuspect);
                logThreshold += LOG_THRESHOLD;
            }
        }

        System.out.println("!!! replaceFamily = " + replaceFamily);
    }

    @Test
    public void primeDigitReplacements_1_3() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 1, 3);

        assertEquals(6, replaceFamily.getFamily());
        assertEquals(3, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{0}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_563() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 563);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(563, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 3}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_7991() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 7991);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(7991, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{1, 4}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_76399() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 76399);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(76399, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 5}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_995369() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 995369);

        assertEquals(7, replaceFamily.getFamily());
        assertEquals(995369, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 5}, replaceFamily.getReplaceIndexes());
    }

    private ReplaceFamily getReplaceFamily(Primes primes, int replaceCount, long canonicalSuspect) {
        ReplaceFamily globalReplaceFamily = ReplaceFamily._null_(canonicalSuspect);

        Digits canonicalSuspectAsDigits = Digits.valueOf(canonicalSuspect);

        ReplaceIterator it = new ReplaceIterator(new GeneralReplaceFactory(), replaceCount, canonicalSuspectAsDigits.size());

        while (it.hasNext()) {
            Replace replace = it.next();

            int familyCounter = replace.getFamily(primes, canonicalSuspectAsDigits);

            if (familyCounter > globalReplaceFamily.getFamily()) {
                globalReplaceFamily = new ReplaceFamily(canonicalSuspect,
                        it.getReplaceIndexes(), familyCounter);
            }
        }

        return globalReplaceFamily;
    }
}