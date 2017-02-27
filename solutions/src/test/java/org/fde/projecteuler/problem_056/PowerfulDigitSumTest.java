package org.fde.projecteuler.problem_056;

import org.junit.Test;

import java.math.BigInteger;

public class PowerfulDigitSumTest {
    @Test
    public void powerfulDigitSumTest() {
        long targetSum  = 0;
        for(int a = 1; a < 100; ++a) {
            for(int b = 1; b < 100; ++b) {
                BigInteger aAsBigInteger = BigInteger.valueOf(a);

                BigInteger result = aAsBigInteger.pow(b);
                String resultAsString = result.toString();

                long sum = 0;

                for(int i = 0; i < resultAsString.length(); ++i) {
                    char ch = resultAsString.charAt(i);
                    int intValueOfChar = (int) ch;

                    int intValue = intValueOfChar - '0';

                    sum += intValue;
                }

                if(sum > targetSum) {
                    targetSum = sum;

                    System.out.println("result = " + result);
                    System.out.println("a = " + a);
                    System.out.println("b = " + b);
                    System.out.println("targetSum = " + targetSum);
                }
            }
        }
    }
}
