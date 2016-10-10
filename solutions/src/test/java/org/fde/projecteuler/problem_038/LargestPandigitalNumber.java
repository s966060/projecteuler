package org.fde.projecteuler.problem_038;

import org.fde.util.ListOfLong;
import org.fde.util.LongUtil;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class LargestPandigitalNumber {
    @Test
    public void largestPandigitalNumber() {
        long target = 0;
        ListOfLong factors = createListOfLong(2, 3, 4, 5, 6, 7, 8, 9);

        nextValue:
        for (long value = 1; value < 10_000L; ++value) {
            StringBuilder concatenated = new StringBuilder();

            concatenated.append(value);

            for (long factor : factors) {
                long product = value * factor;

                concatenated.append(product);

                if (concatenated.length() > 9) {
                    continue nextValue;
                } else if (LongUtil.isPandigital(concatenated.toString())) {
                    System.out.println("concatenated = " + concatenated);
                    target = Long.valueOf(concatenated.toString());
                }
            }
        }

        assertEquals(932_718_654L, target);
    }
}
