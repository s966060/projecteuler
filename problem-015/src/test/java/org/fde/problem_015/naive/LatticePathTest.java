package org.fde.problem_015.naive;

import org.junit.Test;

public class LatticePathTest {
    private static final int LIMIT_DOWN = 3;
    private static final int LIMIT_RIGHT = 1;

    @Test
    public void amountOfRoutesIn_20_x_20_Grid() {
        Result result = new Result();

        findRoute(result, new Context());
        System.out.println("*** result = " + result);
    }

    private void findRoute(Result result, Context ctx) {
        if (ctx.getDown() > LIMIT_DOWN) {
            return;
        }

        if (ctx.getRight() > LIMIT_RIGHT) {
            return;
        }

        if (ctx.getDown() == LIMIT_DOWN && ctx.getRight() == LIMIT_RIGHT) {
            result.count++;

            if((result.count % 10_000_000) == 0) {
                System.out.println("RUNNING result = " + result);
            }

            return;
        }

        for (Direction d : Direction.values()) {
            findRoute(result, ctx.add(d));
        }
    }
}

