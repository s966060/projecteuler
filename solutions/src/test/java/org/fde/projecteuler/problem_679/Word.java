package org.fde.projecteuler.problem_679;

import org.apache.commons.lang3.StringUtils;

public class Word {
    private final StringBuilder word;
    private int cursor;

    public Word(int wordLength) {
        this.word = new StringBuilder(StringUtils.repeat(' ', wordLength));
        this.cursor = 0;
    }

    public void add(char value) {
        this.word.setCharAt(this.cursor, value);
        ++this.cursor;
    }

    public void add(String value) {
        for(int i = 0; i < value.length(); ++i) {
            char ch = value.charAt(i);
            add(ch);
        }
    }

    public void remove() {
        --this.cursor;
    }

    public void remove(String value) {
        this.cursor -= value.length();
    }

    public boolean findTargets() {
        for (String target : FreeFarea.TARGETS) {
            int indexOf = this.word.indexOf(target);

            if (indexOf < 0) {
                return false;
            }
            else {
                int nextIndexOf = this.word.indexOf(target, indexOf + 1);

                if (nextIndexOf < 0) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

}
