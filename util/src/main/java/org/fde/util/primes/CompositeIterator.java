package org.fde.util.primes;

import java.util.Iterator;

public class CompositeIterator implements Iterator<Long> {
    private final PrimeBuilder builder;

    private long current;

    public CompositeIterator(PrimeBuilder builder) {
        this.builder = builder;
        this.current = 0;
    }

    public CompositeIterator(PrimeBuilder builder, long current) {
        this.builder = builder;
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        while(builder.isPrime(current)) {
            ++current;
        }

        long next = current;
        ++current;
        return next;
    }
}
