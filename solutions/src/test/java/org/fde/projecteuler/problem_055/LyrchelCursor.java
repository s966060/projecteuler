package org.fde.projecteuler.problem_055;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class LyrchelCursor {
    private final int cursorDepth;
    private final int maxCursorDepth;

    private final BigInteger initialValue;
    private final BigInteger value;
    private final List<BigInteger> tests;
    private final BigIntegerHolder palindrome;

    private LyrchelCursor(int cursorDepth, int maxCursorDepth, BigInteger value,
            BigInteger initialValue, List<BigInteger> tests,
            BigIntegerHolder palindrome) {

        this.cursorDepth = cursorDepth;
        this.maxCursorDepth = maxCursorDepth;
        this.value = value;
        this.initialValue = initialValue;
        this.tests = tests;
        this.palindrome = palindrome;
    }

    static LyrchelCursor createValueCursor(int value, int maxCursorDepth) {

        BigInteger initialValue = BigInteger.valueOf(value);

        return new LyrchelCursor(0, maxCursorDepth, initialValue, initialValue,
                new ArrayList<>(), new BigIntegerHolder());
    }

    private LyrchelCursor createNextValueCursor(BigInteger newValue) {
        int newCursorDepth = this.cursorDepth + 1;

        return new LyrchelCursor(newCursorDepth, this.maxCursorDepth, newValue,
                this.initialValue, this.tests, this.palindrome);
    }

    private void setPalindrome(BigInteger palindrome) {
        this.palindrome.value = palindrome;
    }

    boolean next() {
        if (cursorDepth >= maxCursorDepth) {
            return true;
        } else {
            BigInteger reverseValue = reverseValue(value);
            BigInteger newValue = value.add(reverseValue);

            this.tests.add(value);
            this.tests.add(reverseValue);

            if (isPalindrome(newValue)) {
                setPalindrome(newValue);
                return false;
            } else {
                return createNextValueCursor(newValue).next();
            }
        }
    }

    private boolean isPalindrome(BigInteger value) {
        String valueAsString = String.valueOf(value);

        String reverseAsString = new StringBuffer(valueAsString).reverse()
                                                                .toString();

        return valueAsString.equals(reverseAsString);
    }

    private BigInteger reverseValue(BigInteger value) {
        String valueAsString = String.valueOf(value);

        String reverseAsString = new StringBuffer(valueAsString).reverse()
                                                                .toString();

        BigInteger reverseValue = new BigInteger(reverseAsString);
        return reverseValue;
    }

    @Override
    public String toString() {
        return "LyrchelCursor{\n" + "cursorDepth=" + cursorDepth + ",\n" +
               " maxCursorDepth=" + maxCursorDepth + ",\n" + " initialValue=" +
               initialValue + ",\n" + " value=" + value + ",\n" + " tests=" +
               tests + ", palindrome=" + palindrome + "\n}";
    }
}
