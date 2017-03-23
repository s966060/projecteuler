package org.fde.projecteuler.problem_060;

import org.fde.util.ListOfLong;
import org.fde.util.combinations.Combination;
import org.fde.util.primes.sieve.PrimeSieve;

import static org.fde.util.primes.sieve.cache_aware.PrimeSieveCacheAwareFactory.createPrimeSieveCacheAwareUsingBitSet;

class PrimePairSet {
    private final PrimeSieve sieve;

    PrimePairSet() {
        this.sieve = createPrimeSieveCacheAwareUsingBitSet(100_000_000);
        this.sieve.sieve();
    }

    boolean isPrimePairSet(Combination combination) {
        ListOfLong list = combination.getAsList();

        Long newOne = combination.getLast();

        for (int i = 0; i < list.size() - 1; ++i) {
            Long first = list.get(i);

            if (!arePrimePairs(first, newOne)) {
                return false;
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

        boolean isPrimePair = sieve.isPrime(suspect);
        return isPrimePair;
    }
}
