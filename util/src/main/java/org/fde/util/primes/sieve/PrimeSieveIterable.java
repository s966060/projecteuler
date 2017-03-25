package org.fde.util.primes.sieve;

public interface PrimeSieveIterable {
    long getLength();

    boolean isPrime(long suspect);
}
