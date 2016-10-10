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

    public static boolean isPalinDrome(long value, int base) {
        String a = Long.toString(value, base);
        String b = new StringBuilder(a).reverse().toString();

        return a.equals(b);
    }

    public static ListOfLong getTruncatedRightValues(final long value) {
        ListOfLong numbers = new ListOfLong();

        DigitList digits = getDigits(value);

        do {
            long number = digits.getValue();
            numbers.add(number);
            digits.truncateRight();
        } while (!digits.isEmpty());


        return numbers;
    }

    public static ListOfLong getTruncatedLeftValues(final long value) {
        ListOfLong numbers = new ListOfLong();

        DigitList digits = getDigits(value);

        do {
            long number = digits.getValue();
            numbers.add(number);
            digits.truncateLeft();
        } while (!digits.isEmpty());

        return numbers;
    }

    public static boolean isPandigital(final long value) {
        return isPandigital(Long.toString(value));
    }

    public static boolean isPandigital(final String value) {
        if (value.length() == 9) {
            if (!value.contains("0")) {
                for (int digit = 1; digit <= 9; ++digit) {
                    if (!value.contains(String.valueOf(digit))) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }
}
