package org.fde.projecteuler.problem_051;

import org.fde.util.DigitList;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.fde.projecteuler.problem_051.ReplaceFamily._null_;

public class PrimeDigitReplacements {

    public static final int LOG_THRESHOLD = 1_000;

    @Test
    public void primeDigitReplacements() {
        Primes primes = new Primes();
        ReplaceFamily replaceFamily2 = getReplaceFamily(primes, 563);

        ReplaceFamily globalReplaceFamily = _null_();

        long logThreshold = LOG_THRESHOLD;

        for (int canonicalSuspect = 1; globalReplaceFamily.getFamily() < 8; ++canonicalSuspect) {
            ReplaceFamily replaceFamily = getReplaceFamily(primes, canonicalSuspect);
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

    private ReplaceFamily getReplaceFamily(Primes primes, long canonicalSuspect) {
        ReplaceFamily globalReplaceFamily = _null_();

        PrimeBuilder builder = new PrimeBuilder(primes);

        DigitList original = DigitList.valueOf(canonicalSuspect);

        for (int first = 0; first < original.size(); ++first) {
            for (int second = first + 1; second < original.size(); ++second) {
                int replaceFamilyCounter = 0;

                for (int digit = 0; digit <= 9; ++digit) {
                    DigitList suspect = new DigitList(original);

                    suspect.add(first, digit);
                    suspect.add(second, digit);

                    long value = suspect.getValue();

                    if (builder.isPrime(value)) {
                        ++replaceFamilyCounter;
                    }
                }

                if (replaceFamilyCounter > globalReplaceFamily.getFamily()) {
                    globalReplaceFamily = new ReplaceFamily(canonicalSuspect,
                            first, second, replaceFamilyCounter);
                }
            }
        }

        return globalReplaceFamily;
    }
}