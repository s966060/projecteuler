package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.regular.PrimeSieveUsingArray;

import java.util.BitSet;

public class PrimeSieveCacheAwareUsingBitSet
        extends PrimeSieveCacheAwareAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private final static int BATCH_SIZE = 1000000;

    private final BitSetStore store;

    public PrimeSieveCacheAwareUsingBitSet(int upTo) {
        this.store = new BitSetStore(upTo);

        // initialize numbers with all prime / composite results <= BATCH_SIZE
        PrimeSieveUsingArray sieve = new PrimeSieveUsingArray(getBatchSize());
        sieve.sieve();

        for(int index = 0; index < sieve.getLength(); ++index) {
            store.setComposite(index, !sieve.isPrime(index));
        }
    }

    int getBatchSize() {
        return BATCH_SIZE;
    }

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAwareUsingBitSet{" +
                "store=" + store +
                '}';
    }

    public boolean isPrime(int index) {
        return store.isPrime(index);
    }

    public int getLength() {
        return store.getLength();
    }

    void setComposite(int index, boolean isComposite) {
        store.setComposite(index, isComposite);
    }
}
