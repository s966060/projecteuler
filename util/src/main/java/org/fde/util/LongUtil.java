package org.fde.util;

public class LongUtil {
    public static ListOfLong getDigits(final long value) {
        if (value == 0) {
            return ListOfLong.createListOfLong(0);
        }

        ListOfLong digitsAsList = new ListOfLong();

        int digits = (int) Math.floor(Math.log10(value)) + 1;

        long newValue = value;

        for (int i = 1; i <= digits; ++i) {
            long digit = newValue % 10;
            newValue /= 10;
            digitsAsList.add(digit);
        }

        digitsAsList.reverse();
        return digitsAsList;
    }
}
