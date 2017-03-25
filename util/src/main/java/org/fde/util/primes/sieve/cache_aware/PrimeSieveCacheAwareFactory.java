package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.store.ArrayStore;
import org.fde.util.primes.sieve.store.BitSetStore;
import org.fde.util.primes.sieve.store.MultiBitSetStore;

public class PrimeSieveCacheAwareFactory {
    public static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingArray(
            int upTo) {

        int batchSize = 1_000_000;

        return createPrimeSieveCacheAwareUsingArray(upTo, batchSize);
    }

    private static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingArray(
            int upTo, int batchSize) {

        ArrayStore store = new ArrayStore(upTo);
        return new PrimeSieveCacheAware(store, batchSize);
    }

    public static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingBitSet(
            int upTo) {

        int batchSize = 1_000_000;

        return createPrimeSieveCacheAwareUsingBitSet(upTo, batchSize);
    }

    private static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingBitSet(
            int upTo, int batchSize) {

        BitSetStore store = new BitSetStore(upTo);
        return new PrimeSieveCacheAware(store, batchSize);
    }

    public static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingMultiBitSet(
            int upTo) {

        int batchSize = 1_000_000;

        return createPrimeSieveCacheAwareUsingMultiBitSet(upTo, batchSize);
    }

    private static PrimeSieveCacheAware createPrimeSieveCacheAwareUsingMultiBitSet(
            int upTo, int batchSize) {

        MultiBitSetStore store = new MultiBitSetStore(upTo);
        return new PrimeSieveCacheAware(store, batchSize);
    }
}
