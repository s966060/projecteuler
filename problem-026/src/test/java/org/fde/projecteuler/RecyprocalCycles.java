package org.fde.projecteuler;

import org.junit.Test;

import java.math.BigDecimal;

class Cycle {
    private final BigDecimal d;
    private final String cycle;

    public Cycle(int d) {
        this.d = BigDecimal.valueOf(d);
        this.cycle = "";
    }

    private Cycle(BigDecimal d, String cycle) {
        this.d = d;
        this.cycle = cycle;
    }

    Cycle addCycle(String cycle) {
        return new Cycle(d, cycle);
    }

    BigDecimal getFraction() {
        return BigDecimal.ONE.divide(d, 100, BigDecimal.ROUND_UP);
    }

    boolean isLarger(Cycle other) {
        return this.cycle.length() > other.cycle.length();
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "d=" + d +
                ", cycle='" + cycle + '\'' +
                ", fraction='" + getFraction() + '\'' +
                '}';
    }
}

public class RecyprocalCycles {
    @Test
    public void recyprocalCycles() {
        Cycle largestCycle = new Cycle(1);

        for (int d = 1; d < 1000; ++d) {
            Cycle cycle = getCycle(new Cycle(d));
            System.out.println("cycle = " + cycle);

            if(cycle.isLarger(largestCycle)) {
                largestCycle = cycle;
            }
        }

        System.out.println("largestCycle = " + largestCycle);
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
        for (int i = 0; i < 4; ++i) {
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
