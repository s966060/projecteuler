package org.fde.problem_021;

import org.fde.util.ListOfLong;
import org.fde.util.primes.Divisors;
import org.junit.Test;

class Target {
    private final long number;
    private final long d;

    public Target(long number, long d) {
        this.number = number;
        this.d = d;
    }

    public long getNumber() {
        return number;
    }

    public long getD() {
        return d;
    }
}

public class AmicableNumberTest {
    @Test
    public void sumOfAmicableNumbersLessThan_10000() {
        Divisors divisors = new Divisors();

        for (int number = 1; number <= 10_000; ++number) {
            ListOfLong list = divisors.getProperDivisors(number);

            list.getSum();
        }
    }
}
