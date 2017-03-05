package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.regular.PrimeSieveUsingArray;
import org.fde.util.primes.sieve.store.ArrayStore;

import java.util.Arrays;

public class PrimeSieveCacheAwareUsingArray
        extends PrimeSieveCacheAwareAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private final static int BATCH_SIZE = 1000000;
    private final ArrayStore arrayStore;

    public PrimeSieveCacheAwareUsingArray(int upTo) {
        this.arrayStore = new ArrayStore(upTo + 1);

        // initialize numbers with all prime / composite results <= BATCH_SIZE
        PrimeSieveUsingArray sieve = new PrimeSieveUsingArray(getBatchSize());
        sieve.sieve();

        System.arraycopy(sieve.getNumbers(), 0, this.arrayStore.numbers, 0,
                Math.min(sieve.getNumbers().length, getLength()));
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
        return "PrimeSieveCacheAwareUsingArray{" +
                "numbers=" + Arrays.toString(arrayStore.numbers) +
                '}';
    }

    public boolean isPrime(int index) {
        return arrayStore.isPrime(index);
    }

    public int getLength() {
        return this.arrayStore.getLength();
    }

    void setComposite(int index, boolean isComposite) {
        this.arrayStore.setComposite(index, isComposite);
    }
}
