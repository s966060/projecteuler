package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveCacheAwareUsingBitSet {
    public static PrimeSieveCacheAwareAlgorithm createPrimeSieveCacheAwareUsingBitSet(int upTo) {
        return new PrimeSieveCacheAwareAlgorithm(new BitSetStore(upTo + 1), 1_000_000);
    }
}
