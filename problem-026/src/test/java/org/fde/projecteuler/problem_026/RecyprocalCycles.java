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
        String asString = suspect.getFraction().toString();

        next:
        for (int begin = 0; begin < asString.length(); ++begin) {
            for (int end = begin + 1; end < asString.length(); ++end) {
                String cycle = asString.substring(begin, end);

                BigDecimal number = getNumber(cycle);

                if (number != null && !number.equals(BigDecimal.ZERO)) {
                    boolean isCycle = isCycle(asString, begin, cycle);

                    if (isCycle) {
                        return suspect.addCycle(cycle);
                    }
                }
            }
        }

        return suspect;
    }

    private BigDecimal getNumber(String number) {
        try {
            return new BigDecimal(number);
        } catch (Exception ex) {
            return null;
        }
    }

    private boolean isCycle(String fraction, int index, String cycle) {
        for (int i = 0; i < 2; ++i) {
            int begin = index + cycle.length() * i;
            int end = begin + cycle.length();

            if (begin >= fraction.length() || end >= fraction.length()) {
                return false;
            }

            String suspect = fraction.substring(begin, end);

            if (!cycle.equals(suspect)) {
                return false;
            }
        }

        return true;
    }
}
