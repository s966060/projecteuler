package org.fde.problem_015;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private final List<Direction> route;
    private final int down;
    private final int right;

    public Context() {
        this.route = new ArrayList<>();
        this.down = 0;
        this.right = 0;
    };

    public Context(List<Direction> route, int down, int right) {
        this.route = route;
        this.down = down;
        this.right = right;
    }

    public Context add(Direction direction) {
        List<Direction> newRoute = new ArrayList<>(this.route);
        newRoute.add(direction);

        int down = this.down;

        if(direction == Direction.DOWN) {
            ++down;
        }

        int right = this.right;

        if(direction == Direction.RIGHT) {
            ++right;
        }

        return new Context(newRoute, down, right);
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
                "route=" + route +
                ", down=" + down +
                ", right=" + right +
                '}';
    }
}
