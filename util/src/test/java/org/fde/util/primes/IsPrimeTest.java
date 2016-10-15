package org.fde.util.primes;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IsPrimeTest {
    @Test
    public void isAPrime() {
        PrimeBuilder builder = new PrimeBuilder();

        assertTrue(false == builder.isPrime(0));
        assertTrue(false == builder.isPrime(1));
        assertTrue(true == builder.isPrime(2));
        assertTrue(true == builder.isPrime(3));
        assertTrue(false == builder.isPrime(4));
        assertTrue(true == builder.isPrime(5));
        assertTrue(false == builder.isPrime(6));

        assertTrue(true == builder.isPrime(101));
        assertTrue(false == builder.isPrime(102));
        assertTrue(true == builder.isPrime(103));
        assertTrue(false == builder.isPrime(104));
        assertTrue(false == builder.isPrime(105));
        assertTrue(false == builder.isPrime(106));

        assertTrue(true == builder.isPrime(1619));
        assertTrue(true == builder.isPrime(1621));
        assertTrue(false == builder.isPrime(1623));
        assertTrue(false == builder.isPrime(1625));
        assertTrue(true == builder.isPrime(1627));
        assertTrue(false == builder.isPrime(1629));
    }

    @Test
    public void backwards() {
        PrimeBuilder builder = new PrimeBuilder();

        assertTrue(false == builder.isPrime(1629));
        assertTrue(true == builder.isPrime(1627));
        assertTrue(false == builder.isPrime(1625));
        assertTrue(false == builder.isPrime(1623));
        assertTrue(true == builder.isPrime(1621));
        assertTrue(true == builder.isPrime(1619));

        assertTrue(false == builder.isPrime(106));
        assertTrue(false == builder.isPrime(105));
        assertTrue(false == builder.isPrime(104));
        assertTrue(true == builder.isPrime(103));
        assertTrue(false == builder.isPrime(102));
        assertTrue(true == builder.isPrime(101));

        assertTrue(false == builder.isPrime(6));
        assertTrue(true == builder.isPrime(5));
        assertTrue(false == builder.isPrime(4));
        assertTrue(true == builder.isPrime(3));
        assertTrue(true == builder.isPrime(2));
        assertTrue(false == builder.isPrime(1));
        assertTrue(false == builder.isPrime(0));
    }

    @Test
    public void isAPrime2() {
        IsPrime isPrime = new IsPrime();

        assertTrue(false == isPrime.isPrime(0));
        assertTrue(false == isPrime.isPrime(1));
        assertTrue(true == isPrime.isPrime(2));
        assertTrue(true == isPrime.isPrime(3));
        assertTrue(false == isPrime.isPrime(4));
        assertTrue(true == isPrime.isPrime(5));
        assertTrue(false == isPrime.isPrime(6));

        assertTrue(true == isPrime.isPrime(101));
        assertTrue(false == isPrime.isPrime(102));
        assertTrue(true == isPrime.isPrime(103));
        assertTrue(false == isPrime.isPrime(104));
        assertTrue(false == isPrime.isPrime(105));
        assertTrue(false == isPrime.isPrime(106));

        assertTrue(true == isPrime.isPrime(1619));
        assertTrue(true == isPrime.isPrime(1621));
        assertTrue(false == isPrime.isPrime(1623));
        assertTrue(false == isPrime.isPrime(1625));
        assertTrue(true == isPrime.isPrime(1627));
        assertTrue(false == isPrime.isPrime(1629));

        assertTrue(false == isPrime.isPrime(393_342_741));
        assertTrue(true == isPrime.isPrime(393_342_743));

        assertTrue(true == isPrime.isPrime(413_158_511));
        assertTrue(false == isPrime.isPrime(413_158_513));

        assertTrue(true == isPrime.isPrime(899_809_363));
        assertTrue(true == isPrime.isPrime(920_419_813));
    }
}
