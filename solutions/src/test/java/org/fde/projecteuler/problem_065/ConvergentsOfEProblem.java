package org.fde.projecteuler.problem_065;

import org.fde.util.Digits;
import org.fde.util.QNumberBigInteger;
import org.fde.util.QNumberLong;
import org.junit.Test;

import java.math.BigInteger;

import static org.fde.util.QNumberBigInteger.numberBigInteger;
import static org.fde.util.QNumberLong.ZERO;
import static org.fde.util.QNumberLong.numberLong;
import static org.junit.Assert.assertEquals;

public class ConvergentsOfEProblem {

    @Test
    public void testWithLong () {
        QNumberLong result = ZERO;

        for (int k = 99; k >= 0; --k) {
            long factor = factorLong(k);

            result = numberLong(factor).plus(result);

            if (k > 0) {
                result = result.inverse();
            }
        }

        System.out.println("result = " + result);
    }

    @Test
    public void testWithBigInteger () {
        QNumberBigInteger result = QNumberBigInteger.ZERO;

        for (int k = 99; k >= 0; --k) {
            BigInteger factor = BigInteger.valueOf(factorLong(k));

            result = numberBigInteger(factor).plus(result);

            if (k > 0) {
                result = result.inverse();
            }
        }

        System.out.println("result = " + result);

        Digits digits = Digits.valueOf(result.n);
        long sum = digits.getSumOfDigits();

        System.out.println("sum = " + sum);
        assertEquals(272, sum);
    }

    private long factorLong(int j) {
        if (j == 0) {
            return 2;
        }

        if (j == 1) {
            return 1;
        }

        int i = j - 2;

        if ((i % 3) == 0) {
            long x = (i / 3) + 1;
            long factor = 2 * x;
            return factor;
        }
        else {
            return 1;
        }
    }
}
