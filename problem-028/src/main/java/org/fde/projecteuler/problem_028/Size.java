package org.fde.projecteuler.problem_028;

/**
 * Created by filipdelbaen on 23/09/16.
 */
public class Size {
    private final int size;
    private int step;

    public Size(int size) {
        this.size = size;
    }

    public int getStep() {
        return 1 + (size / 2);
    }
}
