package org.fde.problem_023;

import org.fde.util.ListOfLong;
import org.fde.util.SetOfLong;
import org.fde.util.primes.Divisors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NonAbundantNumberTest {
    @Test
    public void sumOf() {
        Divisors divisors = new Divisors();
        ListOfLong abundantNumbers = new ListOfLong();

        long LIMIT = 30_000; // 28_123;
        for (long number = 1; number <= LIMIT; ++number) {
            ListOfLong properDivisors = divisors.getProperDivisors(number);

            if (properDivisors.getSum() > number) {
                abundantNumbers.add(number);
            }
        }

        System.out.println("abundantNumbers = " + abundantNumbers);

        SetOfLong sumOfAbundantNumbers = new SetOfLong();

        for (int index = 0; index < abundantNumbers.size(); ++index) {
            long a = abundantNumbers.get(index);

            for (int index2 = index + 1; index2 < abundantNumbers.size(); ++index2) {
                long b = abundantNumbers.get(index2);

                long sum = a + b;

                if (sum <= LIMIT) {
                    sumOfAbundantNumbers.add(sum);
                } else {
                    break;
                }
            }
        }

        System.out.println("sumOfAbundantNumbers = " + sumOfAbundantNumbers);

        long all = LIMIT * (LIMIT + 1) / 2;
        System.out.println("all = " + all);
        long minus = sumOfAbundantNumbers.getSum();
        System.out.println("minus = " + minus);
        long totalSum = all - minus;
        System.out.println("totalSum = " + totalSum);

        assertEquals(4179935L, totalSum);
    }
}
