package org.fde.util.primes;

import org.fde.util.ListOfLong;
import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationList;
import org.fde.util.combinations.factory.CombinationFactory;

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

        for (int index = 0; index < uniqueCombinations.size(); ++index) {
            if (index > 0) {
                Combination c = uniqueCombinations.get(index);
                long product = c.product();
                result.add(product);
            }
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
