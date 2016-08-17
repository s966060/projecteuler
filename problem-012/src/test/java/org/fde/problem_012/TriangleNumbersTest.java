package org.fde.problem_012;

import org.fde.util.combinations.CombinationFactory;
import org.fde.util.combinations.CombinationsList;
import org.fde.util.TriangleNumbers;
import org.fde.util.primes.PrimeFactors;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TriangleNumbersTest {
    @Test
    public void theTriangleNumberWithMoreThan500Divisors() {
        TriangleNumbers numbers = new TriangleNumbers();

        PrimeFactors primeFactors = new PrimeFactors();

        long number = 0;
        int countAllUniqueCombinedPrimeDivisors = 0;
        int countAllCombinedPrimeDivisors = 0;
        CombinationsList combinations = new CombinationsList();
        CombinationsList uniqueCombinations = new CombinationsList();

        // one is not included, so we step at 500 and thus total divisors = 501
        while (countAllUniqueCombinedPrimeDivisors <= 500) {
            number = numbers.next();
            List<Long> factors = primeFactors.getPrimeFactors(number);
            combinations = new CombinationFactory(factors).getCombinations();

            System.out.println("number = " + number);
            countAllCombinedPrimeDivisors = combinations.size();
            System.out.println("countAllCombinedPrimeDivisors = " + countAllCombinedPrimeDivisors);

            uniqueCombinations = combinations.getUnique();
            countAllUniqueCombinedPrimeDivisors = uniqueCombinations.size();
            System.out.println("countAllUniqueCombinedPrimeDivisors = " + countAllUniqueCombinedPrimeDivisors);
        }

        System.out.println("primeFactors = " + primeFactors);
        System.out.println("combinations = " + combinations);
        System.out.println("uniqueCombinations = " + uniqueCombinations);
        System.out.println("number = " + number);

        assertEquals(76576500L, number);
    }
}
