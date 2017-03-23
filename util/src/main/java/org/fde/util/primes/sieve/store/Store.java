package org.fde.util.primes.sieve.store;

public interface Store {
    boolean isPrime(int index);

    int getLength();

    void setComposite(int index, boolean isComposite);

    boolean isCalculatedPrime(long suspect);
}
