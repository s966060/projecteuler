package org.fde.projecteuler.problem_051.general;

import org.fde.projecteuler.problem_051.Replace;
import org.fde.projecteuler.problem_051.ReplaceFamily;
import org.fde.util.Digits;
import org.fde.util.ListOfLong;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;

import java.util.Arrays;

class GeneralReplace implements Replace {
    public static final GeneralReplace NULL = new GeneralReplace(new int[0]);

    private final int[] replaceIndexes;

    public GeneralReplace(int[] replaceIndexes) {
        this.replaceIndexes = Arrays.copyOf(replaceIndexes, replaceIndexes.length);
    }

    public ReplaceFamily getFamily(Primes primes, Digits canonicalSuspectAsDigits) {
        PrimeBuilder primeBuilder = new PrimeBuilder(primes);

        ListOfLong familyPrimes = new ListOfLong();

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
                familyPrimes.add(value);
            }
        }

        return new ReplaceFamily(
                                canonicalSuspectAsDigits.getValue(),
                                replaceIndexes,
                                familyPrimes);
    }

    @Override
    public String toString() {
        return "GeneralReplace{" +
                "replaceIndexes=" + Arrays.toString(replaceIndexes) +
                '}';
    }
}
