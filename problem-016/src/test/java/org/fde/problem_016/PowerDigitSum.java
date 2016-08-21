package org.fde.problem_016;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PowerDigitSum {
    @Test
    public void thePowerDigitSumOf_2_Power_1000() {
        BigInteger two = BigInteger.valueOf(2L);
        BigInteger power = two.pow(1000);
        System.out.println("power = " + power);

        String powerAsString = power.toString();
        System.out.println("powerAsString = " + powerAsString);

        long powerSum = 0;

        for(char ch : powerAsString.toCharArray()) {
            int digit = ch;
            digit -= '0';

            powerSum += digit;
        }

        System.out.println("powerSum = " + powerSum);
    }
}
