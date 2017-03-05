package org.fde.util.primes.sieve.regular;

import org.fde.util.primes.sieve.PrimeSieve;
import org.fde.util.primes.sieve.PrimeSieveIterable;
import org.fde.util.primes.sieve.PrimeSieveIterator;
import org.fde.util.primes.sieve.store.Store;

public class PrimeSieveRegular
        implements PrimeSieve, PrimeSieveIterable {

    private final Store store;

    public PrimeSieveRegular(Store store) {
        this.store = store;
    }

    public final void sieve() {
        int limit = getLimit();

        setComposite(0, true);
        setComposite(1, true);
        setComposite(2, false);

        for (int index = 0; index < limit; ++index) {
            if (isPrime(index)) {
                int prime = index;

                eliminateComposites(prime);
            }
        }
    }

    private void eliminateComposites(int prime) {
        int composite;
        composite = prime + prime;

        while (composite < getLength()) {
            setComposite(composite, true);
            composite += prime;
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

    @Override
    public Iterable<Long> getPrimes() {
        return () -> new PrimeSieveIterator(this);
    }

    @Override
    public String toString() {
        return "PrimeSieveRegular{" +
                "store=" + store.getClass().getSimpleName() +
                ", length=" + store.getLength() +
                '}';
    }
}
