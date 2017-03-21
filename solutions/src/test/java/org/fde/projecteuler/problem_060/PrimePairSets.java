package org.fde.projecteuler.problem_060;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.fde.util.ValueCounter;
import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationList;
import org.fde.util.combinations.iterator.CombinationIterator;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import java.util.List;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.fde.util.combinations.iterator.CombinationIteratorFactory.createCombinationIterator;

public class PrimePairSets {
    @Test
    public void primePairSets() {
        PrimePairSet primePairSet = new PrimePairSet();

        CombinationList suspects = getSuspects();

        ListOfLong primes = getFirstPrimes(3000);

        for (Combination suspect : suspects) {
            ListOfLong asList = suspect.getAsList();

            Long minimum = asList.last();

            int primeIndex = 0;

            for (; primeIndex < primes.size() && minimum > primes.get(primeIndex); ++primeIndex) {

            }

            for (int firstPrimeIndex = primeIndex; firstPrimeIndex < primes.size(); ++firstPrimeIndex) {
                Long firstPrime = primes.get(firstPrimeIndex);

                Combination firstNewCombination = new Combination(suspect);
                firstNewCombination.add(firstPrime);

                if (primePairSet.isPrimePairSet(firstNewCombination)) {
                    System.out.println("@@@ firstNewCombination = " + firstNewCombination);
                    for (int secondPrimeIndex = firstPrimeIndex + 1; secondPrimeIndex < primes.size(); ++secondPrimeIndex) {
                        Long secondPrime = primes.get(secondPrimeIndex);

                        Combination secondNewCombination = new Combination(firstNewCombination);
                        secondNewCombination.add(secondPrime);

                        if (primePairSet.isPrimePairSet(secondNewCombination)) {
                            System.out.println("### secondNewCombination = " + secondNewCombination);
                        }
                    }
                }
            }
        }
    }

    private CombinationList getSuspects() {
        ListOfLong primes = getFirstPrimes(500);
        primes.remove(createListOfLong(2L, 5L));

        System.out.println("primes.last() = " + primes.last());

        CombinationIterator iterator = createCombinationIterator(primes, 3);

        PrimePairSet primePairSet = new PrimePairSet();

        CombinationList suspects = new CombinationList();

        while (iterator.hasNext()) {
            Combination combination = iterator.next();

            if (primePairSet.isPrimePairSet(combination)) {
                suspects.add(combination);
            }
        }

        return suspects;
    }

    private ListOfLong getFirstPrimes(int count) {
        PrimeBuilder builder = new PrimeBuilder();

        for (int i = 0; i < count; ++i) {
            builder.next();
        }

        Primes primes = builder.getPrimes();
        ListOfLong asList = primes.getInternalList();


        return asList;
    }
}