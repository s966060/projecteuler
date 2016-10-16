package org.fde.util;

import org.fde.util.permutations.PermutationFactory;
import org.fde.util.permutations.PermutationList;

public class PandigitalUtil {
    public static PermutationList getNumbers(int lower, int upper) {
        ListOfLong digits = createDigits(lower, upper);

        return new PermutationFactory(digits).getPermutations();
    }

    private static ListOfLong createDigits(int lower, int upper) {
        ListOfLong digits = new ListOfLong();

        for (long digit = lower; digit <= upper; ++digit) {
            digits.add(digit);
        }

        return digits;
    }
}
