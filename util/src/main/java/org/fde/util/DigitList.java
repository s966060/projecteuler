package org.fde.util;

import org.apache.commons.lang3.Validate;

import java.util.Iterator;

public class DigitList implements Iterable<Long> {
    private final ListOfLong digits;

    public DigitList() {
        this.digits = new ListOfLong();
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
}
