package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.regular.PrimeSieveUsingArray;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeSieveCacheAwareUsingArray
        extends PrimeSieveCacheAwareAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private final static int BATCH_SIZE = 1000000;

    private boolean[] numbers;

    public PrimeSieveCacheAwareUsingArray(int upTo) {
        this.numbers = new boolean[upTo + 1];

        // initialize numbers with all prime / composite results <= BATCH_SIZE
        PrimeSieveUsingArray sieve = new PrimeSieveUsingArray(getBatchSize());
        sieve.sieve();

        System.arraycopy(sieve.getNumbers(), 0, this.numbers, 0,
                Math.min(sieve.getNumbers().length, getLength()));
    }

    int getBatchSize() {
        return BATCH_SIZE;
    }

    @Override
    public Iterable<Long> getPrimes() {
        return getPrimeIterable();
    }

    private Iterable<Long> getPrimeIterable() {
        return () -> getPrimeIterator();
    }

    private Iterator<Long> getPrimeIterator() {
        return new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAwareUsingArray{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public boolean isPrime(int index) {
        return !this.numbers[index];
    }

    public int getLength() {
        return this.numbers.length;
    }

    void setComposite(int index, boolean isComposite) {
        this.numbers[index] = isComposite;
    }
}
