package org.fde.util.primes.sieve;

import java.util.Iterator;

class PrimeSieveIterator implements Iterator<Long> {
    private PrimeSieveIterable iterable;
    private int index = 0;

    public PrimeSieveIterator(PrimeSieveIterable iterable) {
        this.iterable = iterable;
    }

    @Override
    public boolean hasNext() {
        for (int search = index; search < iterable.getLength(); ++search) {
            if (iterable.isPrime(search)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Long next() {
        for (int search = index; search < iterable.getLength(); ++search) {
            if (iterable.isPrime(search)) {
                index = search + 1;
                return (long) search;
            }
        }

        throw new IllegalArgumentException("no next found");
    }
}
