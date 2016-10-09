package org.fde.projecteuler.problem_036;

import org.fde.util.LongUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleBasePalinDromes {
    @Test
    public void doubleBasePalinDromes() {
        long total = 0;

        for (long value = 1; value < 1_000_000; ++value) {
            if (LongUtil.isPalinDrome(value, 10)) {
                if (LongUtil.isPalinDrome(value, 2)) {
                    total += value;
                }
            }
        }

        System.out.println("total = " + total);
        assertEquals(872187L, total);
    }
}
