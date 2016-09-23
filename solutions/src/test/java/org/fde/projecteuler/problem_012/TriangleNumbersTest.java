package org.fde.projecteuler.problem_012;

import org.fde.util.ListOfLong;
import org.fde.util.Logger;
import org.fde.util.TriangleNumbers;
import org.fde.util.primes.Divisors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleNumbersTest {
    @Test
    public void theTriangleNumberWithMoreThan500Divisors() {
        TriangleNumbers numbers = new TriangleNumbers();

        Divisors divisors = new Divisors();

        long number = 0;
        ListOfLong divisorList = new ListOfLong();

        // one is not included, so we step at 500 and thus total divisors = 501
        while (divisorList.size() <= 500) {
            number = numbers.next();
            divisorList = divisors.getDivisors(number);
        }

        Logger.log("divisorList = " + divisorList);
        Logger.log("number = " + number);

        assertEquals(76576500L, number);
    }
}
