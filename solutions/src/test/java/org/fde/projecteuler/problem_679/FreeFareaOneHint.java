package org.fde.projecteuler.problem_679;

import org.apache.commons.lang3.Validate;

public class FreeFareaOneHint {
    private final static String HINT = "FREE";

    private final int wordLength;
    private int count;

    public FreeFareaOneHint(int wordLength) {
        this.count = 0;
        this.wordLength = wordLength;
    }

    public int go() {
        Validate.isTrue(wordLength >= HINT.length());

        int free = wordLength - HINT.length();

        for (int i = 0; i <= free; ++i) {
            int before = i;
            int after = free - i;

            StringBuilder word = new StringBuilder(wordLength);
            before(before, after, word);
        }

        return this.count;
    }

    private void before(int before, int after, StringBuilder word) {
        if (before == 0) {
            word.append(HINT);
            after(after, word);
            word.delete(word.length() - HINT.length(), word.length());
        }
        else {
            for (char c : FreeFarea.ALPHABET) {
                word.append(c);
                before(before - 1, after, word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }

    private void after( int after, StringBuilder word) {
        if (after == 0) {
            boolean isTargetFound = FreeFarea.findTarget(word);

            if (isTargetFound) {
                ++count;
            }
        }
        else {
            for (char c : FreeFarea.ALPHABET) {
                word.append(c);
                after(after - 1, word);
                word.deleteCharAt(word.length() - 1);
            }
        }
    }
}
