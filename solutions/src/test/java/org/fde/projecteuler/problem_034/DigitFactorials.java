package org.fde.projecteuler.problem_034;

import org.fde.util.Digit;
import org.fde.util.Digits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitFactorials {
    @Test
    public void digitFactorials() {
        long totalSum = 0;

        // 2_540_160 = 7 * 9 ! = 9! + 9! + 9! ... + 9!
        // we cannot make more than this value using digit factorials
        for (int value = 10; value <= 2_540_160; ++value) {
            Digits digits = Digits.valueOf(value);

            long sum = 0;

            for (Digit digit : digits) {
                sum += factorial(digit.getValue());
            }

            if (sum == value) {
                totalSum += sum;
                System.out.println("sum = " + sum);
                System.out.println("digits = " + digits);
            }
        }

        System.out.println("totalSum = " + totalSum);
        assertEquals(40730L, totalSum);
    }

    private long factorial(long digit) {
        if (digit == 0) {
            return 1;
        } else {
            return digit * factorial(digit - 1);
        }
    }
}
