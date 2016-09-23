package org.fde.projecteuler.problem_026;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class RecyprocalCycles {
    @Test
    public void recyprocalCycles() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Cycle largestCycle = new Cycle(1);

        PrimeBuilder builder = new PrimeBuilder();

        for (long d = builder.next(); d < 1000; d = builder.next()) {
            System.out.println("d = " + d);
            Cycle cycle = getCycle(new Cycle(d));
            // System.out.println("cycle = " + cycle);

            if (cycle.isLarger(largestCycle)) {
                largestCycle = cycle;
                System.out.println("largestCycle = " + largestCycle);
            }
        }

        System.out.println("largestCycle = " + largestCycle);
        System.out.println("stopWatch = " + stopWatch);

        assertEquals(BigDecimal.valueOf(983), largestCycle.getD());
    }

    private Cycle getCycle(Cycle suspect) {
        String fraction = suspect.getFraction().toString().substring(2);

        int cycleLength = suspect.getMaximumTheoreticalCycleLength();
        String cycleAsString = fraction.substring(0, cycleLength);

        for (int begin = 0, end = begin + cycleLength;
             begin < fraction.length() && end < fraction.length();
             begin = end, end = end + cycleLength) {

            String fractionPart = fraction.substring(begin, end);

            if (!fractionPart.equals(cycleAsString)) {
                return suspect;
            }
        }

        // here now we know that we have a cycle... but now we still have to compute the size of the cyle

        String subCycle = getSubCycle(cycleAsString);

        return suspect.addCycle(subCycle);
    }

    private String getSubCycle(String suspectCycle) {
        next:
        for (int cycleLength = 1; cycleLength <= suspectCycle.length(); ++cycleLength) {
            String subCycle = suspectCycle.substring(0, cycleLength);

            for (int begin = 0, end = begin + cycleLength;
                 begin < suspectCycle.length() && end <= suspectCycle.length();
                 begin = end, end = end + cycleLength) {

                String subCyclePart = suspectCycle.substring(begin, end);

                if (!subCyclePart.equals(subCycle)) {
                    continue next;
                }
            }

            if(subCycle.length() * 2 > suspectCycle.length()) {
                return suspectCycle;
            }
            else {
                return subCycle;
            }
        }

        throw new IllegalArgumentException();
    }
}