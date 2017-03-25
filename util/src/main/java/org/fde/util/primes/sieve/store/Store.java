package org.fde.util.primes.sieve.store;

public interface Store {
    boolean isPrime(long suspect);

    long getLength();

    void setComposite(long index, boolean isComposite);

    boolean isCalculatedPrime(long suspect);
}
