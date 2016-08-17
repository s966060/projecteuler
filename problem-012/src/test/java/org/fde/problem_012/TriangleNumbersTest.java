package org.fde.problem_012;

import org.fde.util.primes.PrimeFactors;
import org.junit.Test;

import java.util.List;

public class TriangleNumbersTest {
    @Test
    public void theTriangleNumberWithMoreThan500Divisors() {
        TriangleNumbers numbers = new TriangleNumbers();

        PrimeFactors primeFactors = new PrimeFactors();

        long number = 0;
        int countAllDivisors = 0;

        // one is not included, so we step at 500 and thus total divisors = 501
        while (countAllDivisors <= 500) {
            number = numbers.next();
            List<Long> factors = primeFactors.getPrimeFactors(number);


        }

        System.out.println("primeFactors = " + primeFactors);
        System.out.println("number = " + number);
    }
}
