package org.fde.projecteuler.problem_051.general;

import org.fde.projecteuler.problem_051.Replace;
import org.fde.util.Digits;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;

import java.util.Arrays;

class GeneralReplace implements Replace {
    public static final GeneralReplace NULL = new GeneralReplace(new int[0]);

    private final int[] replaceIndexes;

    public GeneralReplace(int[] replaceIndexes) {
        this.replaceIndexes = Arrays.copyOf(replaceIndexes, replaceIndexes.length);
    }

    public int getFamily(Primes primes, Digits canonicalSuspectAsDigits) {
        int replaceFamilyCounter = 0;

        PrimeBuilder primeBuilder = new PrimeBuilder(primes);

        for (int digit = 0; digit <= 9; ++digit) {
            if(replaceIndexes[0] == 0 && digit == 0) {
                continue;
            }

            Digits suspect = new Digits(canonicalSuspectAsDigits);

            for(int index : replaceIndexes) {
                suspect.add(index, digit);
            }

            long value = suspect.getValue();

            if (primeBuilder.isPrime(value)) {
                ++replaceFamilyCounter;
            }
        }

        return replaceFamilyCounter;
    }

    @Override
    public String toString() {
        return "GeneralReplace{" +
                "replaceIndexes=" + Arrays.toString(replaceIndexes) +
                '}';
    }
}
