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
        CombinationList suspects = getSuspects();

        System.out.println("suspects = " + suspects);
    }

    private CombinationList getSuspects() {
        ListOfLong primes = getFirstPrimes(100);
        primes.remove(createListOfLong(2L, 5L));

        System.out.println("primes.last() = " + primes.last());

        CombinationIterator iterator = createCombinationIterator(primes, 3);

        PrimePairSet primePairSet = new PrimePairSet();

        CombinationList suspects = new CombinationList();

        while (iterator.hasNext()) {
            Combination combination = iterator.next();

            if (primePairSet.isPrimePairSet(combination)) {
                suspects.add(combination);

                System.out.println("### suspect = " + combination);
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
