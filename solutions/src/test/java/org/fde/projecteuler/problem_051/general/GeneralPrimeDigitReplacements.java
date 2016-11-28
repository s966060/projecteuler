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

    @Test
    public void primeDigitReplacements() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = ReplaceFamily._null_(0);

        for (int canonicalSuspect = 1; replaceFamily.getFamily() < 8; ++canonicalSuspect) {
            for(int replaceCount = 2; replaceCount <= 4 && replaceFamily.getFamily() < 8; ++replaceCount) {
                replaceFamily = getReplaceFamily(primes, replaceCount, canonicalSuspect);
            }
        }

        System.out.println("!!! replaceFamily = " + replaceFamily);
        assertEquals(233, replaceFamily.getCanonicalSuspect());
        assertEquals(8, replaceFamily.getFamily());
        assertArrayEquals(new int[]{0, 2, 4}, replaceFamily.getReplaceIndexes());
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
    public void primeDigitReplacements_3_38021() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 3, 38021);

        assertEquals(9, replaceFamily.getFamily());
        assertEquals(38021, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 4, 6}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_1233() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 1233);

        assertEquals(5, replaceFamily.getFamily());
        assertEquals(1233, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{2, 4}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_2133() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 2133);

        assertEquals(5, replaceFamily.getFamily());
        assertEquals(2133, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{0, 3}, replaceFamily.getReplaceIndexes());
    }

    @Test
    public void primeDigitReplacements_2_2313() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, 2313);

        assertEquals(4, replaceFamily.getFamily());
        assertEquals(2313, replaceFamily.getCanonicalSuspect());
        assertArrayEquals(new int[]{0, 2}, replaceFamily.getReplaceIndexes());
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