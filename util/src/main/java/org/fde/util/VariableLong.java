package org.fde.util;

public class VariableLong {
    private long value;

    public VariableLong(long value) {
        this.value = value;
    }

    public VariableLong times(long factor) {
        this.value *= factor;
        return this;
    }

    public VariableLong add(long add) {
        this.value += add;
        return this;
    }

    public long get() {
        return this.value;
    }

    @Override
    public String toString() {
        return "VariableLong{" +
                "value=" + value +
                '}';
    }

    public static VariableLong valueOf(long value) {
        return new VariableLong(value);
    }
}
