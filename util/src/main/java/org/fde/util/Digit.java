package org.fde.util;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DurationFormatUtils;

public class Digit implements Comparable<Digit> {
    private final long digit;

    private Digit(long digit) {
        this.digit = digit;
    }

    private static long TOTAL_ELAPSED =0 ;
    private static final long LOG_THRESHOLD = 1_000_000_000;
    private static long LOG_ELAPSED = LOG_THRESHOLD;

    public static Digit valueOf(long digit) {
        long start = System.nanoTime();

        try {
            Validate.inclusiveBetween(0, 9, digit);
            return new Digit(digit);
        }
        finally {
            long elapsed = System.nanoTime() - start;
            TOTAL_ELAPSED += elapsed;

            if(TOTAL_ELAPSED > LOG_ELAPSED) {
                LOG_ELAPSED += LOG_THRESHOLD;
                System.out.println("@@@ Digit.valueOf() ... elapsed = " + DurationFormatUtils.formatDurationHMS(TOTAL_ELAPSED / 1_000_000));
            }
        }
    }

    @Override
    public int compareTo(Digit other) {
        return Long.compare(this.digit, other.digit);
    }

    public long getValue() {
        return digit;
    }

    @Override
    public String toString() {
        return "Digit{" +
                "digit=" + digit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Digit digit1 = (Digit) o;

        return digit == digit1.digit;
    }

    @Override
    public int hashCode() {
        return (int) (digit ^ (digit >>> 32));
    }
}
