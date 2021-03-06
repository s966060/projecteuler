package org.fde.util;

public class GreatestCommonDivisor {
    public static long gcd(long a, long b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("a = " + a + " b = " + b);
        }

        if (a == b) {
            return a;
        }

        if (a < b) {
            return gcd(b, a);
        }

        long newA = a % b;

        if (newA == 0) {
            return b;
        }

        return gcd (b, newA);
    }
}
