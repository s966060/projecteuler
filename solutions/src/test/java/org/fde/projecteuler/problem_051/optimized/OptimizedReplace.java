package org.fde.projecteuler.problem_051.optimized;

import org.fde.projecteuler.problem_051.Replace;
import org.fde.projecteuler.problem_051.ReplaceFamily;
import org.fde.util.Digits;
import org.fde.util.ListOfLong;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;

import java.util.Arrays;

class OptimizedReplace implements Replace {
    public static final OptimizedReplace NULL = new OptimizedReplace(new int[0], 0);

    private final int[] replaceIndexes;
    private final int targetFamily;

    public OptimizedReplace(int[] replaceIndexes, int targetFamily) {
        this.replaceIndexes = Arrays.copyOf(replaceIndexes, replaceIndexes.length);
        this.targetFamily = targetFamily;
    }

    public ReplaceFamily getFamily(Primes primes, Digits canonicalSuspectAsDigits) {
        int notAPrimeCount = 0;
        final int maxNotAPrimeCount = (10 - targetFamily);

        PrimeBuilder primeBuilder = new PrimeBuilder(primes);

        ListOfLong familyPrimes = new ListOfLong();

        for (int digit = 0; (digit <= 9) && (notAPrimeCount <= maxNotAPrimeCount); ++digit) {
            if(replaceIndexes[0] == 0 && digit == 0) {
                ++notAPrimeCount;
                continue;
            }

            Digits suspect = new Digits(canonicalSuspectAsDigits);

            for(int index : replaceIndexes) {
                suspect.add(index, digit);
            }

            long value = suspect.getValue();

            if (primeBuilder.isPrime(value)) {
                familyPrimes.add(value);
            }
            else {
                ++notAPrimeCount;
            }
        }

        if(notAPrimeCount <= maxNotAPrimeCount) {
            return new ReplaceFamily(
                                canonicalSuspectAsDigits.getValue(),
                                replaceIndexes,
                                familyPrimes);
        }
        else {
            return ReplaceFamily._null_(canonicalSuspectAsDigits.getValue());
        }
    }

    @Override
    public String toString() {
        return "GeneralReplace{" +
                "replaceIndexes=" + Arrays.toString(replaceIndexes) +
                '}';
    }
}
