package org.fde.projecteuler.problem_055;

import org.fde.util.LongUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LychrelNumbers {
    class Current {
        final int suspect;
        final List<Integer> suspects;
        final int depth;
        final List<Integer> lyrchelList;

        Current(int suspect, List<Integer> suspects, int depth, List<Integer> lyrchelList) {
            this.suspect = suspect;
            this.suspects = suspects;
            this.depth = depth;
            this.lyrchelList = lyrchelList;
        }

        boolean isPalindrome() {
            return LongUtil.isPalinDrome(suspect);
        }

        void setPalindrome(int reverse) {
            setProcessed(suspect);
            setProcessed(reverse);
        }

        void setLyrchel(int reverse) {
            setProcessed(suspect);
            setProcessed(reverse);

            if (suspect < this.suspects.size()) {
                this.lyrchelList.add(suspect);
            }

            if (reverse < this.suspects.size()) {
                this.lyrchelList.add(reverse);
            }
        }

        Current next(int newSuspect) {
            Current newCurrent = new Current(
                    newSuspect, suspects, depth + 1, lyrchelList);

            return newCurrent;
        }

        public void setProcessed(int processed) {
            if (processed < this.suspects.size()) {
                this.suspects.set(processed, null);
            }
        }
    }

    @Test
    public void lychrelNumbers() {
        List<Integer> lyrchelList = new ArrayList<>();

        List<Integer> suspects = createSuspects();

        for (Integer suspect : suspects) {
            if (suspect != null) {
                if (isLyrchel(new Current(suspect, suspects, 1, lyrchelList))) {
                    lyrchelList.add(suspect);
                }
            }
        }

        System.out.println("lyrchelList = " + lyrchelList);
        System.out.println("lyrchelList.size() = " + lyrchelList.size());
    }

    private boolean isLyrchel(Current current) {
        if (current.depth > 50) {
            int reverse = (int) LongUtil.reverse(current.suspect);
            current.setLyrchel(reverse);
            return true;
        } else {
            int reverse = (int) LongUtil.reverse(current.suspect);
            int newSuspect = current.suspect + reverse;

            if (LongUtil.isPalinDrome(newSuspect)) {
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

    private List<Integer> createSuspects() {
        List<Integer> suspects = new ArrayList<>();

        for (int i = 0; i < 10000; ++i) {
            suspects.add(i);
        }

        return suspects;
    }
}
