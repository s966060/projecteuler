package org.fde.problem_015;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LatticePathTest {
    private static final int LIMIT = 20;

    @Test
    public void amountOfRoutesIn_20_x_20_Grid() {
        List<Context> routes = new ArrayList<>();

        findRoute(routes, new Context());
        System.out.println("routes.size() = " + routes.size());
    }

    private void findRoute(List<Context> routes, Context ctx) {
        if (ctx.getDown() > LIMIT) {
            return;
        }

        if (ctx.getRight() > LIMIT) {
            return;
        }

        if (ctx.getDown() == LIMIT && ctx.getRight() == LIMIT) {
            routes.add(ctx);

            if((routes.size() % 10000) == 0) {
                System.out.println("RUNNING routes.size() = " + routes.size());
            }

            return;
        }

        for (Direction d : Direction.values()) {
            findRoute(routes, ctx.add(d));
        }
    }
}

