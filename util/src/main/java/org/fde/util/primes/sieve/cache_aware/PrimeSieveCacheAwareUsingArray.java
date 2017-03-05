package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveCacheAwareUsingArray
        extends PrimeSieveCacheAwareAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    public PrimeSieveCacheAwareUsingArray(int upTo) {
        super(new ArrayStore(upTo + 1), 1_000_000);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAwareUsingArray{}";
    }
}
