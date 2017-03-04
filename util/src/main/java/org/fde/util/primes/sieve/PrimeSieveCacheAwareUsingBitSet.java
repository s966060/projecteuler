package org.fde.util.primes.sieve;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;

public class PrimeSieveCacheAwareUsingBitSet implements PrimeSieve, PrimeSieveIterable {
    private final static int BATCH = 1000000;
    private final int limit;
    private final int length;

    private final BitSet numbers;

    public PrimeSieveCacheAwareUsingBitSet(int upTo) {
        this.length = upTo + 1;
        this.numbers = new BitSet(length);

        // initialize numbers with all prime / composite results <= BATCH
        PrimeSieveUsingArray sieve = new PrimeSieveUsingArray(BATCH);
        sieve.sieve();

        for(int index = 0; index < sieve.getLength(); ++index) {
            setComposite(index, !sieve.isPrime(index));
        }

        this.limit = getLimit();
    }

    @Override
    public void sieve() {
        int batchEnd = getLength() / BATCH;

        if ((batchEnd % BATCH) > 0) {
            ++batchEnd;
        }

        for (int primeBatch = 0; primeBatch <= batchEnd; ++primeBatch) {
            for (int compositeBatch = primeBatch + 1; compositeBatch <= batchEnd; ++compositeBatch) {
                sieve(primeBatch, compositeBatch);
            }
        }
    }

    private void sieve(int primeBatch, int compositeBatch) {
        if (compositeBatch <= primeBatch) {
            throw new IllegalArgumentException();
        }

        // BATCH SIZE 1000
        // batch 0 -> 0 ... 999
        // batch 1 -> 1000 ... 1999
        // ...
        int primeBegin = primeBatch * BATCH;
        int primeEnd;
        primeEnd = ((primeBatch + 1) * BATCH) - 1;
        primeEnd = Math.min(primeEnd, limit);
        primeEnd = Math.min(primeEnd, getLength() - 1);

        int compositeBegin = compositeBatch * BATCH;
        int compositeEnd = Math.min(((compositeBatch + 1) * BATCH) - 1, getLength() - 1);

        for (int primeIndex = primeBegin; primeIndex <= primeEnd; ++primeIndex) {
            if (isPrime(primeIndex)) {
                int prime = primeIndex;

                int factor = compositeBegin / prime;

                if ((compositeBegin % prime) > 0) {
                    ++factor;
                }

                int composite = prime * factor;

                while (composite <= compositeEnd) {
                    setComposite(composite, true);
                    composite += prime;
                }
            }
        }
    }

    private int getLimit() {
        int primeLimit = (int) Math.sqrt(getLength()) + 1;
        return Math.min(primeLimit, getLength());
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
                "limit=" + limit +
                ", length=" + length +
                ", numbers=" + numbers +
                '}';
    }

    public boolean isPrime(int index) {
        return !this.numbers.get(index);
    }

    public int getLength() {
        return length;
    }

    private void setComposite(int index, boolean isComposite) {
        this.numbers.set(index, isComposite);
    }
}
