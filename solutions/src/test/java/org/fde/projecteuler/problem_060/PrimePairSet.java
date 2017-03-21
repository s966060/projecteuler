package org.fde.projecteuler.problem_060;

import org.fde.util.ListOfLong;
import org.fde.util.combinations.Combination;
import org.fde.util.primes.PrimeBuilder;

class PrimePairSet {
    private final PrimeBuilder builder;

    PrimePairSet() {
        this.builder = new PrimeBuilder();
    }

    boolean isPrimePairSet(Combination combination) {
        ListOfLong list = combination.getAsList();

        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                Long first = list.get(i);
                Long second = list.get(j);

                if (!isPrimePair(first, second)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPrimePair(Long first, Long second) {
        String firstAsString = first.toString();
        String secondAsString = second.toString();

        if (isPrimePair(firstAsString, secondAsString)) {
            if (isPrimePair(secondAsString, firstAsString)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPrimePair(String first, String second) {
        String suspectAsString = first + second;
        long suspect = Long.parseLong(suspectAsString);

        boolean isPrimePair = builder.isPrime(suspect);
        return isPrimePair;
    }
}
