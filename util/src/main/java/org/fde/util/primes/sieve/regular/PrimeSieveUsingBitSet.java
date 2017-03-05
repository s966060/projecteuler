package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveUsingBitSet
        extends PrimeSieveAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    public PrimeSieveUsingBitSet(int upTo) {
        super(new BitSetStore(upTo + 1));
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingBitSet{}";
    }
}
