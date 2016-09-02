package org.fde.util.primes;

import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationFactory;
import org.fde.util.combinations.CombinationList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by filip on 2/09/2016.
 */
public class Divisors {
    private final PrimeFactors primeFactors;

    public Divisors() {
        this.primeFactors = new PrimeFactors();
    }

    public List<Long> getDivisors(long number) {
        List<Long> result = new ArrayList<>();

        if(number == 0) {
            return result;
        }

        result.add(1L);

        List<Long> factors = primeFactors.getPrimeFactors(number);
        CombinationList combinations = new CombinationFactory(factors).getCombinations();
        CombinationList uniqueCombinations = combinations.getUnique();

        for(Combination c : uniqueCombinations) {
            long product = c.multiply();
            result.add(product);
        }

        Collections.sort(result);
        return result;
    }
}
