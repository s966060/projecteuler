package org.fde.projecteuler.problem_041;

import org.fde.util.DigitList;
import org.fde.util.PandigitalUtil;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationList;
import org.fde.util.primes.IsPrime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PandigitalPrime {
    @Test
    public void pandigitalPrime() {
        long target = 0;

        for (int N = 1; N <= 9; ++N) {
            target = pandigitalPrime(target, N);
        }

        assertEquals(7_652_413L, target);
    }

    private long pandigitalPrime(long target, int N) {
        IsPrime isPrime = new IsPrime();

        PermutationList numbers = PandigitalUtil.getNumbers(1, N);

        for (Permutation number : numbers) {
            DigitList digitList = new DigitList(number.getList());
            long suspect = digitList.getValue();

            if (isPrime.isPrime(suspect)) {
                if (suspect > target) {
                    target = suspect;
                }
            }
        }

        return target;
    }
}
