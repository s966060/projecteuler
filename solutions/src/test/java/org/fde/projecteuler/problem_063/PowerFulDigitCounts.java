package org.fde.projecteuler.problem_063;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class PowerFulDigitCounts {
    @Test
    public void powerFulDigitCounts() {
        int count = 0;

        for (int power = 1; power < 100; ++power) {
            BigInteger lowerLimit = computePower(10, power - 1);
            BigInteger upperLimit = computePower(10, power);

            System.out.println("#############################################");
            System.out.println("### POWER " + power);
            System.out.printf("### lower limit = | %30d |%n", lowerLimit);
            System.out.printf("### upper limit = | %30d |%n", upperLimit);

            int localCount = 0;

            for (long number = 1; number < 10; ++number) {
                BigInteger result = computePower(number, power);

                if (result.compareTo(lowerLimit) >= 0 && result.compareTo(upperLimit) < 0) {
                    System.out.printf("%10d        | %30d |%n", number, result);

                    ++count;
                    ++localCount;
                }
            }

            if (localCount == 0) {
                break;
            }
        }

        System.out.println("count = " + count);
        assertEquals(49, count);
    }

    private BigInteger computePower(long number, int power) {
        BigInteger result = BigInteger.ONE;

        for (int index = 1; index <= power; ++index) {
            result = result.multiply(BigInteger.valueOf(number));
        }

        return result;
    }
}
