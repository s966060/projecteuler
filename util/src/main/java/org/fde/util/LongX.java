package org.fde.util;

public class LongX implements Comparable<LongX> {
    private final long value;

    private LongX(long value) {
        this.value = value;
    }

    public LongX add(LongX other) {
        return LongX.valueOf(this.value + other.value);
    }

    public LongX mul(LongX other) {
        return LongX.valueOf(this.value * other.value);
    }

    public static LongX valueOf(long value) {
        return new LongX(value);
    }

    @Override
    public int compareTo(LongX other) {
        return Long.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return "LongX{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LongX longX = (LongX) o;

        return value == longX.value;

    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }
}
