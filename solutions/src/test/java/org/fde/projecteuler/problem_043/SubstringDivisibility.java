package org.fde.projecteuler.problem_043;

import org.fde.util.ListOfLong;
import org.fde.util.PandigitalUtil;
import org.fde.util.VariableLong;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationList;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubstringDivisibility {
    @Test
    public void substringDivisibility() {
        long total = 0;

        PermutationList permutations = PandigitalUtil.getNumbers(0, 9);

        nextPermutation:
        for (Permutation p : permutations) {
            if (isSubstringDividable(p)) {
                ListOfLong list = p.getList();

                VariableLong number = getNumber(list);

                System.out.println("number = " + number);

                total += number.get();
            }
        }

        System.out.println("total = " + total);
        assertEquals(16_695_334_890L, total);
    }

    private boolean isSubstringDividable(Permutation p) {
        PrimeBuilder builder = new PrimeBuilder();

        ListOfLong list = p.getList();

        for (int index = 2; index <= 8; ++index) {
            ListOfLong subList = list.subList(index - 1, index - 1 + 3);

            VariableLong number = getNumber(subList);

            long divider = builder.next();

            if ((number.get() % divider) != 0) {
                return false;
            }
        }

        return true;
    }

    private VariableLong getNumber(ListOfLong subList) {
        final VariableLong number = VariableLong.valueOf(0L);

        subList.forEach(aLong -> {
            number.times(10).add(aLong);
        });

        return number;
    }
}
