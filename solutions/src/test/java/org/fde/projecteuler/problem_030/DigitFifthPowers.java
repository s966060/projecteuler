package org.fde.projecteuler.problem_030;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DigitFifthPowers {
    @Test
    public void digitFifthPowers() {
        ListOfLong targets = new ListOfLong();

        for (long suspect = 10; suspect < 1000000; ++suspect) {
            ListOfLong digits = getDigits(suspect);

            long sum = 0;

            for (Long digit : digits) {
                sum += Math.pow(digit, 5);
            }

            if (suspect == sum) {
                targets.add(suspect);
            }
        }

        System.out.println("targets = " + targets);
        System.out.println("targets.size() = " + targets.size());
        long totalSum = targets.getSum();

        assertEquals(443839L, totalSum);
    }

    private ListOfLong getDigits(long suspect) {
        String suspectAsString = String.valueOf(suspect);

        ListOfLong digits = new ListOfLong();

        for (int i = 0; i < suspectAsString.length(); ++i) {
            char digitAsChar = suspectAsString.charAt(i);
            long digit = digitAsChar - '0';

            digits.add(digit);

        }

        return digits;
    }
}
