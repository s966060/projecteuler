package org.fde.projecteuler.problem_026;

import java.math.BigDecimal;

/**
 * Created by filip on 22/09/2016.
 */
class Cycle {
    private final BigDecimal d;
    private final String cycle;
    private BigDecimal fraction;

    public Cycle(long d) {
        this.d = BigDecimal.valueOf(d);
        this.cycle = "";
    }

    private Cycle(BigDecimal d, String cycle, BigDecimal fraction) {
        this.d = d;
        this.cycle = cycle;
        this.fraction = fraction;
    }

    Cycle addCycle(String cycle) {
        return new Cycle(d, cycle, fraction);
    }

    BigDecimal getFraction() {
        if (fraction == null) {
            fraction = BigDecimal.ONE.divide(d, 2000, BigDecimal.ROUND_UP);
        }

        return fraction;
    }

    boolean isLarger(Cycle other) {
        return this.cycle.length() > other.cycle.length();
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "d=" + d +
                ", cycle='" + cycle + '\'' +
                ", fraction=" + fraction +
                '}';
    }

    public BigDecimal getD() {
        return d;
    }
}
