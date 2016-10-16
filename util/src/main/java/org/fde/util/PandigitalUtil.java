package org.fde.util;

import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationFactory;
import org.fde.util.permutations.PermutationList;

public class PandigitalUtil {
    public static PermutationList getNumbers(int lower, int upper) {
        ListOfLong digits = createDigits(lower, upper);

        PermutationList all = new PermutationFactory(digits).getPermutations();

        PermutationList withoutLeadingZero = new PermutationList();

        for (Permutation p : all) {
            if (!p.getList().get(0).equals(0L)) {
                withoutLeadingZero.add(p);
            }
        }

        return withoutLeadingZero;
    }

    private static ListOfLong createDigits(int lower, int upper) {
        ListOfLong digits = new ListOfLong();

        for (long digit = lower; digit <= upper; ++digit) {
            digits.add(digit);
        }

        return digits;
    }
}
