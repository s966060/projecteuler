package org.fde.util.primes.sieve;

import java.util.Arrays;
import java.util.Iterator;

public class PrimeSieveCacheAware {
    private final static int BATCH = 1000;

    private boolean[] numbers;

    public PrimeSieveCacheAware(int upTo) {
        this.numbers = new boolean[upTo + 1];

        // initialize numbers with all prime / composite results <= BATCH
        PrimeSieve sieve = new PrimeSieve(BATCH);
        sieve.sieve();

        System.arraycopy(sieve.getNumbers(), 0, this.numbers, 0,
                Math.min(sieve.getNumbers().length, this.numbers.length));
    }

    public void sieve() {
        int limit = getLimit();

        int batchEnd = this.numbers.length / BATCH;

        if ((batchEnd % BATCH) > 0) {
            ++batchEnd;
        }

        for (int primeBatch = 0; primeBatch <= batchEnd; ++primeBatch) {
            for (int compositeBatch = primeBatch + 1; compositeBatch <= batchEnd; ++compositeBatch) {
                sieve(limit, primeBatch, compositeBatch);
            }
        }
    }

    private void sieve(int limit, int primeBatch, int compositeBatch) {
        if (compositeBatch <= primeBatch) {
            throw new IllegalArgumentException();
        }

        // BATCH SIZE 1000
        // batch 0 -> 0 ... 999
        // batch 1 -> 1000 ... 1999
        // ...
        int primeBegin = primeBatch * BATCH;
        int primeEnd = Math.min(Math.min(((primeBatch + 1) * BATCH) - 1, limit), numbers.length - 1);

        int compositeBegin = compositeBatch * BATCH;
        int compositeEnd = Math.min(((compositeBatch + 1) * BATCH) - 1, numbers.length - 1);

        for (int primeIndex = primeBegin; primeIndex <= primeEnd; ++primeIndex) {
            if (!this.numbers[primeIndex]) {
                int prime = primeIndex;

                int factor = compositeBegin / prime;

                if ((compositeBegin % prime) > 0) {
                    ++factor;
                }

                int composite = prime * factor;

                while (composite <= compositeEnd) {
                    this.numbers[composite] = true;
                    composite += prime;
                }
            }
        }
    }

    private int getLimit() {
        int primeLimit = (int) Math.sqrt(this.numbers.length) + 1;
        return Math.min(primeLimit, this.numbers.length);
    }

    public Iterable<Long> getPrimes() {
        return getPrimeIterable();
    }

    private Iterable<Long> getPrimeIterable() {
        return () -> getPrimeIterator();
    }

    private Iterator<Long> getPrimeIterator() {
        return new Iterator<Long>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                for (int search = index; search < numbers.length; ++search) {
                    if (!numbers[search]) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public Long next() {
                for (int search = index; search < numbers.length; ++search) {
                    if (!numbers[search]) {
                        index = search + 1;
                        return (long) search;
                    }
                }

                throw new IllegalArgumentException("no next found");
            }
        };
    }

    @Override
    public String toString() {
        return "PrimeSieveCacheAware{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }
}
