package org.fde.projecteuler.problem_679.fail_last;

import org.apache.commons.lang3.Validate;
import org.fde.projecteuler.problem_679.FreeFarea;

public class FreeFareaTwoHints {
    private final static String [] HINTS =  { "FREE", "AREA" };

    private final int wordLength;
    private int count;

    private String hint_1;
    private String hint_2;

    public FreeFareaTwoHints(int wordLength) {
        this.count = 0;
        this.wordLength = wordLength;
    }

    public int go() {
        int hintLength = HINTS[0].length() + HINTS[1].length();
        Validate.isTrue(wordLength >= hintLength);

        int free = wordLength - hintLength;

        for (int i = 0; i < HINTS.length; ++i) {
            int j = (i + 1) % 2;
            this.hint_1 = HINTS[i];
            this.hint_2 = HINTS[j];

            for (int before = 0; before <= free; ++before) {
                int after = free - before;

                Word word = new Word(wordLength);
                before_1(before, after, word);
            }
        }

        return this.count;
    }

    private void before_1(int before, int after, Word word) {
        if (before == 0) {
            word.add(this.hint_1);
            before_2(after, word);
            word.remove(this.hint_1);
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
            word.add(this.hint_2);
            after(0, word);
            word.remove(this.hint_2);
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
            word.add(this.hint_2);
            after(after, word);
            word.remove(this.hint_2);
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
