package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveCacheAwareUsingBitSet
        extends PrimeSieveCacheAwareAlgorithm {

    private PrimeSieveCacheAwareUsingBitSet(int upTo) {
        super(new BitSetStore(upTo + 1), 1_000_000);
    }

    public static PrimeSieveCacheAwareUsingBitSet createPrimeSieveCacheAwareUsingBitSet(int upTo) {
        return new PrimeSieveCacheAwareUsingBitSet(upTo);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAwareUsingBitSet{}";
    }
}
