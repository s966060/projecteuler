package org.fde.problem_015;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private final int down;
    private final int right;

    public Context() {
        this.down = 0;
        this.right = 0;
    };

    public Context(int down, int right) {
        this.down = down;
        this.right = right;
    }

    public Context add(Direction direction) {
        int down = this.down;

        if(direction == Direction.DOWN) {
            ++down;
        }

        int right = this.right;

        if(direction == Direction.RIGHT) {
            ++right;
        }

        return new Context(down, right);
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "Context{" +
                "down=" + down +
                ", right=" + right +
                '}';
    }
}
