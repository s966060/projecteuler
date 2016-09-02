package org.fde.problem_020;

import org.fde.util.Logger;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class SumDigitsOfTheResultOfFactorial_100 {
    public static BigInteger factorial(BigInteger n) {
        BigInteger result = BigInteger.ONE;

        while (!n.equals(BigInteger.ZERO)) {
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return result;
    }

    @Test
    public void sumOfDigits() {
        BigInteger factorial = factorial(BigInteger.valueOf(100L));
        Logger.log("factorial = " + factorial);

        String asString = factorial.toString();

        int sum = 0;

        for (char ch : asString.toCharArray()) {
            sum += (ch - '0');
        }

        Logger.log("sum = " + sum);
        assertEquals(648, sum);
    }
}
