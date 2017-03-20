package org.fde.projecteuler.problem_060;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.fde.util.ValueCounter;
import org.fde.util.combinations.Combination;
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
        StopWatch stopWatch = StopWatchUtil.createAndStart();

        ListOfLong primes = getFirstPrimes(2000);
        primes.remove(createListOfLong(2L, 5L));

        ValueCounter<Long> valueCounter = new ValueCounter<>(primes.getInternalList());

        System.out.println("primes.last() = " + primes.last());

        CombinationIterator iterator = createCombinationIterator(primes, 5);

        PrimeBuilder builder = new PrimeBuilder();

        long progress = 0;

        nextCombination:
        while (iterator.hasNext()) {
            Combination combination = iterator.next();
            ListOfLong combinationAsList = combination.getAsList();

            ++progress;

            if ((progress % 100_000_000) == 0) {
                System.out.println("stopWatch = " + stopWatch);
                System.out.println("progress = " + progress + " @ combination = " + combination);
            }

            for (int i = 0; i < combinationAsList.size(); ++i) {
                for (int j = i + 1; j < combinationAsList.size(); ++j) {
                    Long first = combinationAsList.get(i);
                    Long second = combinationAsList.get(j);

                    if (!isPrimePair(builder, first, second)) {
                        continue nextCombination;
                    }
                }
            }

            for (int i = 0; i < combinationAsList.size(); ++i) {
                Long value = combinationAsList.get(i);
                valueCounter.put(value);
            }

            System.out.println("### ");
            System.out.println("### combination = " + combination);
            System.out.println("### ");
        }

        List<Long> notParticipating = valueCounter.getCount(0);

        System.out.println("notParticipating = " + notParticipating);


    }

    private boolean isPrimePair(PrimeBuilder builder, Long first, Long second) {
        long suspect;
        String suspectAsString;

        suspectAsString = first + "" + second;
        suspect = Long.parseLong(suspectAsString);

        if (builder.isPrime(suspect)) {
            suspectAsString = second + "" + first;
            suspect = Long.parseLong(suspectAsString);

            if (builder.isPrime(suspect)) {
                return true;
            }
        }

        return false;
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
