package org.fde.util.primes.sieve.cache_aware;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.regular.PrimeSieveRegular;
import org.fde.util.primes.sieve.store.Store;

import static org.fde.util.primes.sieve.regular.PrimeSieveRegularFactory.createPrimeSieveUsingArray;

public class PrimeSieveCacheAware
        implements PrimeSieveIterable, PrimeSieve {

    private final Store store;
    private final int batchSize;

    public PrimeSieveCacheAware(Store store, int batchSize) {
        this.store = store;
        this.batchSize = batchSize;
    }

    public final void sieve() {
        initializeSieve();

        long batchEnd = getLength() / getBatchSize();

        if ((batchEnd % getBatchSize()) > 0) {
            ++batchEnd;
        }

        for (long primeBatch = 0; primeBatch <= batchEnd; ++primeBatch) {
            for (long compositeBatch = primeBatch + 1; compositeBatch <= batchEnd; ++compositeBatch) {
                sieve(primeBatch, compositeBatch);
            }
        }
    }

    private void initializeSieve() {
        // initialize numbers with all prime / composite results <= BATCH_SIZE
        PrimeSieveRegular sieve = createPrimeSieveUsingArray(getBatchSize());
        sieve.sieve();

        long length = Math.min(sieve.getLength(), store.getLength());

        for (long index = 0; index < length; ++index) {
            store.setComposite(index, !sieve.isPrime(index));
        }
    }

    private void sieve(long primeBatch, long compositeBatch) {
        if (compositeBatch <= primeBatch) {
            throw new IllegalArgumentException();
        }

        // BATCH SIZE 1000
        // batch 0 -> 0 ... 999
        // batch 1 -> 1000 ... 1999
        // ...
        long primeBegin = primeBatch * getBatchSize();
        long primeEnd;
        primeEnd = ((primeBatch + 1) * getBatchSize()) - 1;
        primeEnd = Math.min(primeEnd, getLimit());
        primeEnd = Math.min(primeEnd, getLength() - 1);

        long compositeBegin = compositeBatch * getBatchSize();
        long compositeEnd = Math.min(((compositeBatch + 1) * getBatchSize()) - 1, getLength() - 1);

        for (long primeIndex = primeBegin; primeIndex <= primeEnd; ++primeIndex) {
            if (isPrime(primeIndex)) {
                long prime = primeIndex;

                long factor = compositeBegin / prime;

                if ((compositeBegin % prime) > 0) {
                    ++factor;
                }

                long composite = prime * factor;

                while (composite <= compositeEnd) {
                    setComposite(composite, true);
                    composite += prime;
                }
            }
        }
    }

    private long getLimit() {
        long primeLimit = (long) Math.sqrt(getLength()) + 1;
        return Math.min(primeLimit, getLength());
    }

    @Override
    public boolean isPrime(long suspect) {
        return this.store.isPrime(suspect);
    }

    @Override
    public long getLength() {
        return this.store.getLength();
    }

    void setComposite(long value, boolean isComposite) {
        this.store.setComposite(value, isComposite);
    }

    int getBatchSize() {
        return batchSize;
    }

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
    }

    @Override
    public boolean isCalculatedPrime(long suspect) {
        return this.store.isCalculatedPrime(suspect);
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAware{" +
                "store=" + store.getClass().getSimpleName() +
                ", length=" + store.getLength() +
                '}';
    }
}
