package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.regular.PrimeSieveUsingArray;
import org.fde.util.primes.sieve.store.Store;

public abstract class PrimeSieveCacheAwareAlgorithm
        implements PrimeSieveIterable, PrimeSieve {

    private final Store store;
    private final int batchSize;

    public PrimeSieveCacheAwareAlgorithm(Store store, int batchSize) {
        this.store = store;
        this.batchSize = batchSize;

        // initialize numbers with all prime / composite results <= BATCH_SIZE
        PrimeSieveUsingArray sieve = new PrimeSieveUsingArray(getBatchSize());
        sieve.sieve();

        for (int index = 0; index < sieve.getLength(); ++index) {
            store.setComposite(index, !sieve.isPrime(index));
        }
    }

    public final void sieve() {
        int batchEnd = getLength() / getBatchSize();

        if ((batchEnd % getBatchSize()) > 0) {
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
        int primeBegin = primeBatch * getBatchSize();
        int primeEnd;
        primeEnd = ((primeBatch + 1) * getBatchSize()) - 1;
        primeEnd = Math.min(primeEnd, getLimit());
        primeEnd = Math.min(primeEnd, getLength() - 1);

        int compositeBegin = compositeBatch * getBatchSize();
        int compositeEnd = Math.min(((compositeBatch + 1) * getBatchSize()) - 1, getLength() - 1);

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
    public boolean isPrime(int index) {
        return this.store.isPrime(index);
    }

    @Override
    public int getLength() {
        return this.store.getLength();
    }

    void setComposite(int index, boolean isComposite) {
        this.store.setComposite(index, isComposite);
    }

    int getBatchSize() {
        return batchSize;
    }

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAwareAlgorithm{" +
                "store=" + store +
                '}';
    }
}
