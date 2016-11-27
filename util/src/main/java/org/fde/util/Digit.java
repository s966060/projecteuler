package org.fde.util;

import org.apache.commons.lang3.Validate;

public class Digit implements Comparable<Digit> {
    private final long digit;

    private Digit(long digit) {
        this.digit = digit;
    }

    public static Digit valueOf(long digit) {
        Validate.inclusiveBetween(0, 9, digit);
        return new Digit(digit);
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
}
