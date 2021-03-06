package org.fde.util;

import java.math.BigInteger;
import java.util.Iterator;

public class Digits implements Iterable<Digit> {
    private final MyList<Digit> digits;

    public Digits() {
        this.digits = new MyList<>();
    }

    public Digits(ListOfLong list) {
        this();

        for (long value : list) {
            add(value);
        }
    }

    public Digits(Digits other) {
        this.digits = new MyList<>(other.digits);
    }

    public void add(long digit) {
        this.digits.add(Digit.valueOf(digit));
    }

    public void reverse() {
        this.digits.reverse();
    }

    public void rotateRight() {
        this.digits.rotateRight();
    }

    @Override
    public Iterator<Digit> iterator() {
        return this.digits.iterator();
    }

    public long getValue() {
        long total = 0;

        for (Digit digit : this) {
            total *= 10;
            total += digit.getValue();
        }

        return total;
    }

    public long getSumOfDigits() {
        long total = 0;

        for (Digit digit : this) {
            total += digit.getValue();
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

    public static Digits createDigitList(Integer... digits) {
        Digits list = new Digits();

        for (Integer digit : digits) {
            list.add(digit);
        }

        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Digits digits1 = (Digits) o;

        return digits.equals(digits1.digits);
    }

    @Override
    public int hashCode() {
        return digits.hashCode();
    }

    public void sort() {
        this.digits.sort();
    }

    public int size() {
        return this.digits.size();
    }

    public static Digits valueOf(final long value) {
        Digits digitList = new Digits();

        if (value == 0) {
            digitList.add(0);
            return digitList;
        }

        int digits = (int) Math.floor(Math.log10(value)) + 1;

        long newValue = value;

        for (int i = 1; i <= digits; ++i) {
            long digit = newValue % 10;
            newValue /= 10;
            digitList.add(digit);
        }

        digitList.reverse();
        return digitList;
    }

    public static Digits valueOf(final BigInteger value) {
        Digits digitList = new Digits();

        if (value.equals(BigInteger.ZERO)) {
            digitList.add(0);
            return digitList;
        }

        BigInteger temp = value;

        while (!temp.equals(BigInteger.ZERO)) {
            BigInteger [] x = temp.divideAndRemainder(BigInteger.TEN);

            int digit = x[1].intValue();
            digitList.add(digit);

            temp = x[0];
        }

        digitList.reverse();
        return digitList;
    }

    public void add(int index, long digit) {
        this.digits.add(index, Digit.valueOf(digit));
    }

    public ListOfLong toListOfLong() {
        ListOfLong list = new ListOfLong();

        for (Digit d : this) {
            list.add(d.getValue());
        }

        return list;
    }

    @Override
    public String toString() {
        return "Digits{" +
                "digits=" + digits +
                '}';
    }
}
