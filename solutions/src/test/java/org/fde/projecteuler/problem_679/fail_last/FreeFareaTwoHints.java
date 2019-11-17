package org.fde.projecteuler.problem_679.fail_last;

import org.apache.commons.lang3.Validate;
import org.fde.projecteuler.problem_679.FreeFarea;

public class FreeFareaTwoHints {
    private final static String HINT_1 = "FREE";
    private final static String HINT_2 = "AREA";

    private final int wordLength;
    private int count;

    public FreeFareaTwoHints(int wordLength) {
        this.count = 0;
        this.wordLength = wordLength;
    }

    public int go() {
        int hintLength = HINT_1.length() + HINT_2.length();
        Validate.isTrue(wordLength >= hintLength);

        int free = wordLength - hintLength;

        for (int before = 0; before <= free; ++before) {
            int after = free - before;

            Word word = new Word(wordLength);
            before_1(before, after, word);
        }

        return this.count;
    }

    private void before_1(int before, int after, Word word) {
        if (before == 0) {
            word.add(HINT_1);
            before_2(after, word);
            word.remove(HINT_1);
        }
        else {
            for (char c : FreeFarea.ALPHABET) {
                word.add(c);
                before_1(before - 1, after, word);
                word.remove();
            }
        }
    }

    private void before_2(int free, Word word) {
        if (free == 0) {
            word.add(HINT_2);
            after(0, word);
            word.remove(HINT_2);
        }
        else {
            for (int before = 0; before <= free; ++before) {
                int after = free - before;

                before_2(before, after, word);
            }
        }
    }

    private void before_2(int before, int after, Word word) {
        if (before == 0) {
            word.add(HINT_2);
            after(after, word);
            word.remove(HINT_2);
        }
        else {
            for (char c : FreeFarea.ALPHABET) {
                word.add(c);
                before_2(before - 1, after, word);
                word.remove();
            }
        }
    }

    private void after(int after, Word word) {
        if (after == 0) {
            boolean isTargetFound = word.findTargets();

            if (isTargetFound) {
                ++count;
            }
        }
        else {
            for (char c : FreeFarea.ALPHABET) {
                word.add(c);
                after(after - 1, word);
                word.remove();
            }
        }
    }
}
