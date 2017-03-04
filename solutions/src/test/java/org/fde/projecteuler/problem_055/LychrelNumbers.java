package org.fde.projecteuler.problem_055;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.math.BigInteger.valueOf;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class LychrelNumbers {
    class Current {
        final BigInteger suspect;
        final int depth;

        final List<Long> suspects;
        final Set<Long> lyrchelList;
        final List<BigInteger> palindromeList;

        Current(BigInteger suspect, List<Long> suspects, int depth, Set<Long> lyrchelList) {
            this.suspect = suspect;
            this.suspects = suspects;
            this.depth = depth;
            this.lyrchelList = lyrchelList;
            this.palindromeList = new ArrayList<>();
        }

        Current(BigInteger suspect, List<Long> suspects, int depth, Set<Long> lyrchelList, List<BigInteger> palindromeList) {
            this.suspect = suspect;
            this.suspects = suspects;
            this.depth = depth;
            this.lyrchelList = lyrchelList;
            this.palindromeList = palindromeList;
        }

        void setPalindrome(BigInteger reverse) {
            palindromeList.add(reverse);
            palindromeList.add(suspect);

            setProcessed(suspect);
            setProcessed(reverse);
        }

        void setLyrchel(BigInteger reverse) {
            setProcessed(suspect);
            setProcessed(reverse);

            if (suspect.compareTo(valueOf(this.suspects.size())) < 0) {
                this.lyrchelList.add(suspect.longValue());
            }

            if (reverse.compareTo(valueOf(this.suspects.size())) < 0) {
                this.lyrchelList.add(reverse.longValue());
            }
        }

        Current next(BigInteger newSuspect) {
            Current newCurrent = new Current(
                    newSuspect, suspects, depth + 1, lyrchelList, palindromeList);

            return newCurrent;
        }

        public void setProcessed(BigInteger processed) {
            if (processed.compareTo(valueOf(this.suspects.size())) < 0) {
                this.suspects.set(processed.intValue(), null);
            }
        }
    }

    @Test
    public void test349() {
        Set<Long> lyrchelList = new TreeSet<>();

        List<Long> suspects = createSuspects();

        Current current = new Current(valueOf(349), suspects, 1, lyrchelList);
        assertFalse(isLyrchel(current));

        assertEquals(
                asList(valueOf(3124), valueOf(4213), valueOf(2921), valueOf(1292), valueOf(943), valueOf(349)),
                current.palindromeList);

        System.out.println("current.palindromeList = " + current.palindromeList);
    }

    @Test
    public void test47() {
        Set<Long> lyrchelList = new TreeSet<>();

        List<Long> suspects = createSuspects();

        Current current = new Current(valueOf(47), suspects, 1, lyrchelList);
        assertEquals(false, isLyrchel(current));

        assertEquals(
                asList(valueOf(74), valueOf(47)),
                current.palindromeList);

        System.out.println("current.palindromeList = " + current.palindromeList);
    }

    @Test
    public void test4994() {
        Set<Long> lyrchelList = new TreeSet<>();

        List<Long> suspects = createSuspects();

        Current current = new Current(valueOf(4994), suspects, 1, lyrchelList);
        assertTrue(isLyrchel(current));
    }

    @Test
    public void lychrelNumbers() {
        Set<Long> lyrchelList = new TreeSet<>();

        List<Long> suspects = createSuspects();

        for (Long suspect : suspects) {
            if (suspect != null) {
                if (isLyrchel(new Current(valueOf(suspect), suspects, 1, lyrchelList))) {
                    lyrchelList.add(suspect);
                }
            }
        }

        System.out.println("lyrchelList = " + lyrchelList);
        System.out.println("lyrchelList.size() = " + lyrchelList.size());
    }

    private boolean isLyrchel(Current current) {
        if (current.depth >= 50) {
            BigInteger  reverse = reverse(current.suspect);
            current.setLyrchel(reverse);
            return true;
        } else {
            BigInteger reverse = reverse(current.suspect);
            BigInteger newSuspect = current.suspect.add(reverse);

            if (isPalinDrome(newSuspect)) {
                current.setPalindrome(reverse);
                return false;
            }

            Current next = current.next(newSuspect);

            if (isLyrchel(next)) {
                current.setLyrchel(reverse);
                return true;
            } else {
                current.setPalindrome(reverse);
                return false;
            }
        }
    }

    private boolean isPalinDrome(BigInteger value) {
        String valueAsString = value.toString();

        String reverseAsString = new StringBuilder(valueAsString).reverse().toString();

        return valueAsString.equals(reverseAsString);
    }

    private BigInteger reverse(BigInteger value) {
        StringBuilder valueAsString = new StringBuilder(value.toString());
        BigInteger reverse = new BigInteger(valueAsString.reverse().toString());
        return reverse;
    }

    private List<Long> createSuspects() {
        List<Long> suspects = new ArrayList<>();

        for (long i = 0; i < 10000; ++i) {
            suspects.add(i);
        }

        return suspects;
    }
}
