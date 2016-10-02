package org.fde.projecteuler.problem_033;

import org.fde.util.ListOfLong;
import org.fde.util.primes.PrimeFactors;
import org.fde.util.primes.Primes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DigitCancellingFractions {
    @Test
    public void digitCancellingFractions() {
        List<Division> target = new ArrayList<>();

        for (int digit = 1; digit <= 9; ++digit) {
            List<Division> divisions = Division.createDivisions(digit);

            for (Division d : divisions) {
                if (d.isCancellable()) {
                    System.out.println("d = " + d);
                    target.add(d);
                }
            }
        }

        ListOfLong numerators = new ListOfLong();
        ListOfLong denumerators = new ListOfLong();

        for (Division d : target) {
            numerators.add((long) d.getNumerator().value);
            denumerators.add((long) d.getDenumerator().value);
        }

        long numerator = numerators.getProduct();
        long denumerator = denumerators.getProduct();

        System.out.println("numerator = " + numerator);
        System.out.println("denumerator = " + denumerator);

        PrimeFactors primeFactors = new PrimeFactors();
        ListOfLong factorsNumerator = primeFactors.getPrimeFactors(numerator);
        ListOfLong factorsDenumerator = primeFactors.getPrimeFactors(denumerator);

        System.out.println("factorsNumerator = " + factorsNumerator);
        System.out.println("factorsDenumerator = " + factorsDenumerator);

        ListOfLong commonFactors = factorsNumerator.getIntersection(factorsDenumerator);
        System.out.println("commonFactors = " + commonFactors);

        factorsNumerator.remove(commonFactors);
        factorsDenumerator.remove(commonFactors);

        System.out.println("factorsNumerator = " + factorsNumerator);
        System.out.println("factorsDenumerator = " + factorsDenumerator);

        long simplifiedDenumberator = factorsDenumerator.getProduct();

        assertEquals(100, simplifiedDenumberator);
    }
}
