package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.store.ArrayStore;

public class PrimeSieveUsingArray
        extends PrimeSieveAlgorithm
        implements PrimeSieve, PrimeSieveIterable {

    private final ArrayStore store;

    public PrimeSieveUsingArray(int upTo) {
        this.store = new ArrayStore(upTo + 1);

    }

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveUsingArray{" +
                "numbers=" + this.store +
                '}';
    }

    public boolean[] getNumbers() {
        return this.store.getNumbers();
    }

    public  boolean isPrime(int index) {
        return this.store.isPrime(index);
    }

    public  int getLength() {
        return this.store.getLength();
    }

    void setComposite(int index, boolean isComposite) {
        this.store.setComposite(index, isComposite);
    }
}
