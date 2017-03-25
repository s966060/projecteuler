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
        long limit = getLimit();

        setComposite(0, true);
        setComposite(1, true);
        setComposite(2, false);

        for (long suspect = 0; suspect < limit; ++suspect) {
            if (isPrime(suspect)) {
                long prime = suspect;

                eliminateComposites(prime);
            }
        }
    }

    private void eliminateComposites(long prime) {
        long composite;
        composite = prime + prime;

        while (composite < getLength()) {
            setComposite(composite, true);
            composite += prime;
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
        long length = this.store.getLength();
        return length;
    }

    void setComposite(long value, boolean isComposite) {
        this.store.setComposite(value, isComposite);
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
        return "PrimeSieveRegular{" +
                "store=" + store.getClass().getSimpleName() +
                ", length=" + store.getLength() +
                '}';
    }
}
