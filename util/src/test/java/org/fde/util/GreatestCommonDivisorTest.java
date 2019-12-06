package org.fde.util;

import org.junit.Test;

import static org.fde.util.GreatestCommonDivisor.gcd;
import static org.junit.Assert.assertEquals;

public class GreatestCommonDivisorTest {
    @Test
    public void test_1() {
        assertEquals(1, gcd(1, 1));
        assertEquals(1, gcd(2, 1));
        assertEquals(1, gcd(3, 1));
        assertEquals(1, gcd(3, 2));
        assertEquals(3, gcd(3, 3));
        assertEquals(1, gcd(3, 4));
        assertEquals(5, gcd(5, 15));
        assertEquals(3, gcd(9, 12));
        assertEquals(5, gcd(500, 505));
        assertEquals(10, gcd(40, 90));
    }
}
