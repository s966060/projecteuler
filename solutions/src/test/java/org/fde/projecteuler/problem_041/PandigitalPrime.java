package org.fde.projecteuler.problem_041;

import org.fde.util.DigitList;
import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationFactory;
import org.fde.util.permutations.PermutationList;
import org.fde.util.primes.IsPrime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PandigitalPrime {
    @Test
    public void pandigitalPrime() {
        long target = 0;

        IsPrime isPrime = new IsPrime();

        for (int N = 1; N <= 9; ++N) {
            ListOfLong digits = new ListOfLong();

            for (long digit = 1; digit <= N; ++digit) {
                digits.add(digit);
            }

            PermutationList list = new PermutationFactory(digits).getPermutations();

            for (Permutation c : list) {
                DigitList digitList = new DigitList(c.getList());
                long suspect = digitList.getValue();

                if (isPrime.isPrime(suspect)) {
                    if (suspect > target) {
                        target = suspect;
                    }
                }
            }
        }

        assertEquals(7_652_413L, target);
    }
}
