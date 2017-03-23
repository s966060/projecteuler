package org.fde.projecteuler.problem_060;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationList;

class FindPrimePairSets {
    private final PrimePairSet primePairSet;
    private final int recurseSize;

    FindPrimePairSets(int recurseSize) {
        this.primePairSet = new PrimePairSet();
        this.recurseSize = recurseSize;
    }


    CombinationList find(ListOfLong primes) {
        CombinationList suspects = new CombinationList();

        for (Long prime : primes) {
            suspects.add(new Combination(prime));
        }

        CombinationList targets = find(suspects, primes, 1);
        return targets;
    }

    private CombinationList find(CombinationList suspects, ListOfLong primes, int recurseIndex) {
        if (recurseIndex == this.recurseSize) {
            return suspects;
        }

        StopWatch stopWatch = StopWatchUtil.createAndStart();

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

        return find(targets, primes, nextRecurseIndex);
    }
}
