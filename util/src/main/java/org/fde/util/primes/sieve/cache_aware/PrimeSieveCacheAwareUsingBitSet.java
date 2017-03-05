package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveCacheAwareUsingBitSet
        extends PrimeSieveCacheAwareAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    public PrimeSieveCacheAwareUsingBitSet(int upTo) {
        super(new BitSetStore(upTo + 1), 1_000_000);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAwareUsingBitSet{}";
    }
}
