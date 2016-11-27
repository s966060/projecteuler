package org.fde.projecteuler.problem_051;

import org.fde.util.Digits;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.fde.projecteuler.problem_051.ReplaceFamily._null_;

public class PrimeDigitReplacements {

    public static final int LOG_THRESHOLD = 1_000;

    @Test
    public void primeDigitReplacements() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily = getReplaceFamily(primes, 1, 3);
        System.out.println("replaceFamily = " + replaceFamily);
    }

    private void f () {
        Primes primes = new Primes();
        ReplaceFamily globalReplaceFamily = ReplaceFamily._null_(0);

        long logThreshold = LOG_THRESHOLD;

        for (int canonicalSuspect = 1; globalReplaceFamily.getFamily() < 8; ++canonicalSuspect) {
            ReplaceFamily replaceFamily = getReplaceFamily(primes, 2, canonicalSuspect);
            globalReplaceFamily = replaceFamily;

            if (replaceFamily.getFamily() >= 6) {
                System.out.println("canonicalSuspect = " + canonicalSuspect);
                System.out.println("replaceFamily = " + replaceFamily);
            }

            if (canonicalSuspect > logThreshold) {
                System.out.println("log ... " + canonicalSuspect);
                logThreshold += LOG_THRESHOLD;
            }
        }
    }

    private ReplaceFamily getReplaceFamily(Primes primes, int replaceCount, long canonicalSuspect) {
        ReplaceFamily globalReplaceFamily = ReplaceFamily._null_(canonicalSuspect);

        Digits canonicalSuspectAsDigits = Digits.valueOf(canonicalSuspect);

        ReplaceIterator it = new ReplaceIterator(replaceCount, canonicalSuspectAsDigits.size());

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