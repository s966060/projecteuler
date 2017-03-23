package org.fde.projecteuler.problem_060;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.fde.util.combinations.CombinationList;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;

public class PrimePairSets {
    @Test
    public void primePairSets() {
        StopWatch stopWatch = StopWatchUtil.createAndStart();

        ListOfLong primes = getFirstPrimes(5000);
        System.out.println("primes.last() = " + primes.last());

        CombinationList targets = new FindPrimePairSets(5).find(primes);

        System.out.println("targets = " + targets);
    }

    private ListOfLong getFirstPrimes(int count) {
        PrimeBuilder builder = new PrimeBuilder();

        for (int i = 0; i < count; ++i) {
            builder.next();
        }

        Primes primes = builder.getPrimes();
        ListOfLong asList = primes.getInternalList();

        asList.remove(createListOfLong(2L, 5L));
        return asList;
    }
}
