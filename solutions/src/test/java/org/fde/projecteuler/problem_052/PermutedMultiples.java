package org.fde.projecteuler.problem_052;

import org.fde.util.Digits;
import org.fde.util.ListOfLong;
import org.fde.util.SetOfLong;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PermutedMultiples {
    @Test
    public void permutedMultiples() {
        Long found = null;

        nextSuspect:
        for(long suspect = 1; found == null; ++suspect) {
            ListOfLong referenceAsList = Digits.valueOf(suspect).toListOfLong();

            if(referenceAsList.first().equals(1L)) {
                SetOfLong referenceAsSet = new SetOfLong(referenceAsList);

                for (int i = 2; i <= 6; ++i) {
                    long try2 = suspect * i;

                    ListOfLong tryAsList = Digits.valueOf(try2).toListOfLong();
                    SetOfLong tryAsSet = new SetOfLong(tryAsList);

                    if (!tryAsSet.equals(referenceAsSet)) {
                        continue nextSuspect;
                    }
                }

                found = suspect;
            }
        }

        System.out.println("found = " + found);
        assertEquals(Long.valueOf(142857L), found);
    }
}
