package org.fde.projecteuler.problem_048;

import org.junit.Test;

public class SelfPowers {
    @Test
    public void selfPowers() {
        final long digitLimit = 10_000_000_000L;
        long sum = 0;

        for (int n = 1; n <= 1000; ++n) {
            long power = 1;

            for (int i = 1; i <= n; ++i) {
                power *= n;
                power %= digitLimit;
            }

            sum += power;
        }

        long lastTenDigits = sum % digitLimit;

        System.out.println("sum = " + sum);
        System.out.println("lastTenDigits = " + lastTenDigits);
    }
}
