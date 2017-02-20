package org.fde.util;

public class LongUtil {

    public static ListOfLong getRotatedValues(final long value) {
        ListOfLong numbers = new ListOfLong();
        numbers.add(value);

        Digits digits = Digits.valueOf(value);
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

    public static boolean isPalinDrome(long value) {
        return isPalinDrome(value, 10);
    }

    public static long reverse(long value) {
        return reverse(value, 10);
    }

    public static long reverse(long value, int base) {
        String original = Long.toString(value, base);
        String reverse = new StringBuilder(original).reverse().toString();

        return Long.valueOf(reverse);
    }

    public static ListOfLong getTruncatedRightValues(final long value) {
        ListOfLong numbers = new ListOfLong();

        Digits digits = Digits.valueOf(value);

        do {
            long number = digits.getValue();
            numbers.add(number);
            digits.truncateRight();
        } while (!digits.isEmpty());


        return numbers;
    }

    public static ListOfLong getTruncatedLeftValues(final long value) {
        ListOfLong numbers = new ListOfLong();

        Digits digits = Digits.valueOf(value);

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

    public static boolean isEven(long value) {
        return (value & 1) == 0;
    }
}
