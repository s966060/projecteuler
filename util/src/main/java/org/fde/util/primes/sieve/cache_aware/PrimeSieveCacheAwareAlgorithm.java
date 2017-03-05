package org.fde.util.primes.sieve.cache_aware;

public abstract class PrimeSieveCacheAwareAlgorithm {
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

    abstract boolean isPrime(int index);

    abstract void setComposite(int index, boolean isComposite);

    abstract int getBatchSize();

    abstract int getLength();
}
