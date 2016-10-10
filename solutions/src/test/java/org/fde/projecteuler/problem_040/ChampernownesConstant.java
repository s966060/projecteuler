package org.fde.projecteuler.problem_040;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChampernownesConstant {
    @Test
    public void champernownesConstant() {
        StringBuilder fraction = new StringBuilder();

        int number = 1;

        while (fraction.length() < 1_000_000) {
            fraction.append(number);
            ++number;
        }

        String fractionAsString = fraction.toString();

        long product = 1;

        for (int i = 1; i <= 1_000_000; i *= 10) {
            int digit = fractionAsString.charAt(i - 1) - '0';
            product *= digit;
        }

        System.out.println("product = " + product);
        assertEquals(210, product);
    }
}
