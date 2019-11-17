package org.fde.projecteuler.problem_679.fail_fast.state_machine;

import org.apache.commons.lang3.StringUtils;
import org.fde.projecteuler.problem_679.FreeFarea;
import org.fde.projecteuler.problem_679.fail_fast.state_machine.Machines;

public class Word {
    private final StringBuilder word;
    private int cursor;

    private final Machines machines;

    public Word(int wordLength) {
        this.word = new StringBuilder(StringUtils.repeat(' ', wordLength));
        this.cursor = 0;
        this.machines = new Machines();
    }

    public void add(char value) {
        this.word.setCharAt(this.cursor, value);
        ++this.cursor;

        machines.push(value);
    }

    public void add(String value) {
        for(int i = 0; i < value.length(); ++i) {
            char ch = value.charAt(i);
            add(ch);
        }
    }

    public void remove() {
        --this.cursor;

        machines.pop();
    }

    public void remove(String value) {
        for(int i = 0; i  < value.length(); ++i) {
            remove();
        }
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

    public boolean isDone() {
        return this.machines.hasAll();
    }

    public boolean isValid() {
        return this.machines.isValid();
    }
}
