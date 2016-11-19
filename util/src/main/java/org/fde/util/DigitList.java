package org.fde.util;

import org.apache.commons.lang3.Validate;

import java.util.Iterator;

public class DigitList implements Iterable<Long> {
    private final ListOfLong digits;

    public DigitList() {
        this.digits = new ListOfLong();
    }

    public DigitList(ListOfLong list) {
        this();

        for (long value : list) {
            add(value);
        }
    }

    public void add(long digit) {
        Validate.inclusiveBetween(0, 9, digit);
        this.digits.add(digit);
    }

    public void reverse() {
        this.digits.reverse();
    }

    public void rotateRight() {
        this.digits.rotateRight();
    }

    @Override
    public Iterator<Long> iterator() {
        return this.digits.iterator();
    }

    public long getValue() {
        long total = 0;

        for (Long digit : this) {
            total *= 10;
            total += digit;
        }

        return total;
    }

    public boolean isEmpty() {
        return this.digits.isEmpty();
    }

    public void truncateRight() {
        this.digits.removeLast();
    }

    public void truncateLeft() {
        this.digits.removeFirst();
    }

    public static DigitList createDigitList(Integer... digits) {
        DigitList list = new DigitList();

        for(Integer digit: digits) {
            list.add(digit);
        }

        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DigitList longs = (DigitList) o;

        return digits.equals(longs.digits);

    }

    @Override
    public int hashCode() {
        return digits.hashCode();
    }
}
