package org.fde.util;

import java.math.BigInteger;

import static org.fde.util.GreatestCommonDivisor.gcd;

public class LeastCommonMultiple {
    public static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        long c = a * b / gcd;
        return c;
    }

    public static BigInteger lcm(BigInteger a, BigInteger b) {
        BigInteger gcd = a.gcd(b);
        BigInteger c = a.multiply(b).divide(gcd);
        return c;
    }
}
