package org.fde.util;

public class LongUtil {
    public static DigitList getDigits(final long value) {
        DigitList digitList = new DigitList();

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

    public static ListOfLong getRotatedValues(final long value) {
        ListOfLong numbers = new ListOfLong();
        numbers.add(value);

        DigitList digits = getDigits(value);
        digits.rotateRight();
        long number = digits.getValue();

        while (number != value) {
            numbers.add(number);
            digits.rotateRight();
            number = digits.getValue();
        }

        return numbers;
    }
}
