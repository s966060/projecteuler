package org.fde.problem_016;

import org.fde.util.Logger;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class PowerDigitSum {
    @Test
    public void thePowerDigitSumOf_2_Power_1000() {
        BigInteger two = BigInteger.valueOf(2L);
        BigInteger power = two.pow(1000);
        Logger.log("power = " + power);

        String powerAsString = power.toString();
        Logger.log("powerAsString = " + powerAsString);

        long powerSum = 0;

        for (char ch : powerAsString.toCharArray()) {
            int digit = ch;
            digit -= '0';

            powerSum += digit;
        }

        Logger.log("powerSum = " + powerSum);

        assertEquals(1366L, powerSum);
    }
}
