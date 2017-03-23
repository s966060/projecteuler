package org.fde.projecteuler.problem_060;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationList;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.primes.Primes;

import static org.fde.util.ListOfLong.createListOfLong;

class FindPrimePairSets {
    private final PrimePairSet primePairSet;

    private final int recurseSize;

    FindPrimePairSets(int recurseSize) {
        this.primePairSet = new PrimePairSet();
        this.recurseSize = recurseSize;
    }


    CombinationList find(int primeSize) {
        CombinationList suspects = new CombinationList();

        ListOfLong primes = getFirstPrimes(primeSize);

        for (Long prime : primes) {
            suspects.add(new Combination(prime));
        }

        CombinationList targets = find(suspects, primeSize, 1);
        return targets;
    }

    private CombinationList find(CombinationList suspects, int primeSize, int recurseIndex) {
        if (recurseIndex == this.recurseSize) {
            return suspects;
        }

        StopWatch stopWatch = StopWatchUtil.createAndStart();

        ListOfLong primes = getFirstPrimes(primeSize);

        long progress = 0;

        CombinationList targets = new CombinationList();

        for (Combination suspect : suspects) {
            int primeIndex = primes.findIndexOf(suspect.getLast());

            for (primeIndex = primeIndex + 1; primeIndex < primes.size(); ++primeIndex) {
                ++progress;

                if ((progress % 1_000_000) == 0) {
                    System.out.println("progress = " + progress + " @ " + stopWatch);
                }

                Long prime = primes.get(primeIndex);

                Combination newSuspect = new Combination(suspect);
                newSuspect.add(prime);

                if (this.primePairSet.isPrimePairSet(newSuspect)) {
                    targets.add(newSuspect);
                }
            }
        }

        int nextRecurseIndex = recurseIndex + 1;

        System.out.println("stopWatch = " + stopWatch);
        System.out.println("nextRecurseIndex = " + nextRecurseIndex);
        System.out.println("targets.size() = " + targets.size());

        return find(targets, primeSize * 2, nextRecurseIndex);
    }

    private ListOfLong getFirstPrimes(int count) {
        PrimeBuilder builder = new PrimeBuilder();

        for (int i = 0; i < count + 2; ++i) {
            builder.next();
        }

        Primes primes = builder.getPrimes();
        ListOfLong asList = primes.getInternalList();

        asList.remove(createListOfLong(2L, 5L));
        return asList;
    }
}
