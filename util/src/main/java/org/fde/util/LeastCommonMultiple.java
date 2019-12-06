package org.fde.util;

import static org.fde.util.GreatestCommonDivisor.gcd;

public class LeastCommonMultiple {
    public static long lcm(long a, long b) {
        long gcd = gcd(a, b);
        long c = a * b / gcd;
        return c;
    }
}
