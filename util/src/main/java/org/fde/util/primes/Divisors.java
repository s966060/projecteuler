package org.fde.util.primes;

import org.fde.util.ListOfLong;
import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationFactory;
import org.fde.util.combinations.CombinationList;

import java.util.ArrayList;
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

    public ListOfLong getDivisors(long number) {
        ListOfLong result = new ListOfLong();

        if (number == 0) {
            return result;
        }

        result.add(1L);

        ListOfLong factors = primeFactors.getPrimeFactors(number);
        CombinationList combinations = new CombinationFactory(factors).getCombinations();
        CombinationList uniqueCombinations = combinations.getUnique();

        for (Combination c : uniqueCombinations) {
            long product = c.multiply();
            result.add(product);
        }

        result.sort();
        return result;
    }

    public ListOfLong getProperDivisors(long number) {
        ListOfLong divisors = getDivisors(number);
        divisors.removeLast();
        return divisors;
    }
}
