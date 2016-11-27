package org.fde.projecteuler.problem_051;

import org.fde.util.DigitList;
import org.fde.util.LongUtil;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.fde.projecteuler.problem_051.ReplaceFamily._null_;

public class PrimeDigitReplacements {

    public static final int LOG_THRESHOLD = 1_000_000;

    @Test
    public void primeDigitReplacements() {
        Primes primes = new Primes();

        PrimeBuilder builder = new PrimeBuilder(primes);
        builder.next(7); // next prime would be 11 then...

        ReplaceFamily globalReplaceFamily = _null_();

        long logThreshold = 1_000_000;

        while (globalReplaceFamily.getFamily() < 8) {
            long suspectPrime = builder.next();

            ReplaceFamily replaceFamily = getReplaceFamily(primes, suspectPrime);
            globalReplaceFamily = replaceFamily;

            if (replaceFamily.getFamily() >= 6) {
                System.out.println("suspectPrime = " + suspectPrime);
                System.out.println("replaceFamily = " + replaceFamily);
            }

            if(suspectPrime > logThreshold) {
                System.out.println("log ... " + suspectPrime);
                logThreshold += LOG_THRESHOLD;
            }
        }
    }

    private ReplaceFamily getReplaceFamily(Primes primes, long suspectPrime) {
        ReplaceFamily globalReplaceFamily = _null_();

        PrimeBuilder builder = new PrimeBuilder(primes);

        DigitList original = DigitList.valueOf(suspectPrime);

        for (int first = 0; first < original.size(); ++first) {
            for (int second = first + 1; second < original.size(); ++second) {
                DigitList suspect = new DigitList(original);
                int replaceFamilyCounter = 0;

                for (int digit = 1; digit <= 9; ++digit) {
                    suspect.set(first, digit);
                    suspect.set(second, digit);

                    long value = suspect.getValue();

                    if (builder.isPrime(value)) {
                        ++replaceFamilyCounter;
                    }
                }

                if (replaceFamilyCounter > globalReplaceFamily.getFamily()) {
                    globalReplaceFamily = new ReplaceFamily(suspect.getValue(),
                            first, second, replaceFamilyCounter);
                }
            }
        }

        return globalReplaceFamily;
    }
}