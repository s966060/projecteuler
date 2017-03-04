package org.fde.util;

import org.fde.util.primes.PrimeFactors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RatioTest {
    @Test
    public void add() {
        Ratio actual = new Ratio(1, 3).add(new Ratio(2, 5));

        assertEquals(new Ratio(11, 15), actual);
    }

    @Test
    public void mul() {
        Ratio actual = new Ratio(1, 3).mul(new Ratio(2, 5));

        assertEquals(new Ratio(2, 15), actual);
    }

    @Test
    public void div() {
        Ratio actual = new Ratio(1, 3).div(new Ratio(2, 5));

        assertEquals(new Ratio(5, 6), actual);
    }

    @Test
    public void simplify() {
        PrimeFactors factors = new PrimeFactors();

        int nominator = 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9;
        int denominator = 3 * 4 * 5 * 6 * 7 * 8;

        Ratio actual = new Ratio(nominator, denominator).simplify(factors);

        assertEquals(new Ratio(18, 1), actual);
    }
}
