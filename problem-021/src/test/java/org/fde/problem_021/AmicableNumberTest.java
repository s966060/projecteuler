package org.fde.problem_021;

import org.fde.util.primes.Divisors;
import org.junit.Test;

public class AmicableNumberTest {
    @Test
    public void sumOfAmicableNumbersLessThan_10000() {
        Divisors divisors = new Divisors();

        for (int number = 1; number <= 10_000; ++number) {
            divisors.getProperDivisors(number);
        }
    }
}
