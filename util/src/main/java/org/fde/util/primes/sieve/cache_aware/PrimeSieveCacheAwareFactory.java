package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.store.ArrayStore;
import org.fde.util.primes.sieve.store.BitSetStore;

public class PrimeSieveCacheAwareFactory {
    public static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingArray(int upTo) {
        ArrayStore store = new ArrayStore(upTo + 1);
        return new PrimeSieveCacheAware(store, 1_000_000);
    }

    public static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingBitSet(int upTo) {
        BitSetStore store = new BitSetStore(upTo + 1);
        return new PrimeSieveCacheAware(store, 1_000_000);
    }
}
