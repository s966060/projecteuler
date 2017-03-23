package org.fde.projecteuler.problem_060;

import org.fde.util.ListOfLong;
import org.fde.util.combinations.Combination;
import org.fde.util.primes.PrimeBuilder;

class PrimePairSet {
    private final PrimeBuilder builder;

    PrimePairSet() {
        this.builder = new PrimeBuilder();
        this.builder.setIsPrimeLookUpLimit(100_000_000);
    }

    boolean isPrimePairSet(Combination combination) {
        ListOfLong list = combination.getAsList();

        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                Long first = list.get(i);
                Long second = list.get(j);

                if (!arePrimePairs(first, second)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean arePrimePairs(long first, long second) {
        if (isPrimePair(first, second)) {
            if (isPrimePair(second, first)) {
                return true;
            }
        }

        return false;
    }

    private long getSizeFactor(long value) {
        if (value < 10) {
            return 10;
        } else if (value < 100) {
            return 100;
        } else if (value < 1_000) {
            return 1_000;
        } else if (value < 10_000) {
            return 10_000;
        } else if (value < 100_000) {
            return 100_000;
        } else if (value < 1_000_000) {
            return 1_000_000;
        } else {
            throw new IllegalArgumentException("getSizeFactor(" + value + ")");
        }
    }

    private boolean isPrimePair(long first, long second) {
        long factor = getSizeFactor(second);
        long suspect = first * factor + second;

        boolean isPrimePair = builder.isPrime(suspect);
        return isPrimePair;
    }
}
