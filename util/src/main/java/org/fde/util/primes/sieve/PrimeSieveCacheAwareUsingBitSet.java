package org.fde.util.primes.sieve;

import java.util.BitSet;
import java.util.Iterator;

public class PrimeSieveCacheAwareUsingBitSet
        extends PrimeSieveCacheAwareAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private final static int BATCH_SIZE = 1000000;
    private final int length;

    private final BitSet numbers;

    public PrimeSieveCacheAwareUsingBitSet(int upTo) {
        this.length = upTo + 1;
        this.numbers = new BitSet(length);

        // initialize numbers with all prime / composite results <= BATCH_SIZE
        PrimeSieveUsingArray sieve = new PrimeSieveUsingArray(getBatchSize());
        sieve.sieve();

        for(int index = 0; index < sieve.getLength(); ++index) {
            setComposite(index, !sieve.isPrime(index));
        }
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
        return "PrimeSieveCacheAwareUsingBitSet{" +
                "length=" + length +
                ", numbers=" + numbers +
                '}';
    }

    public boolean isPrime(int index) {
        return !this.numbers.get(index);
    }

    public int getLength() {
        return length;
    }

    void setComposite(int index, boolean isComposite) {
        this.numbers.set(index, isComposite);
    }
}
