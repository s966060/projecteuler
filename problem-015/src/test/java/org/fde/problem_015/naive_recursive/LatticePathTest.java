package org.fde.problem_015.naive_recursive;

import org.junit.Ignore;
import org.junit.Test;

public class LatticePathTest {
    private static final int LIMIT_DOWN = 20;
    private static final int LIMIT_RIGHT = 20;

    // will take many hours... do not do this for "large values"
    // the result is (n+n) ! / (n ! *n !)
    // n = 20 ---> 137846528820 paths
    // this implementation will at least compute that many paths
    // because also paths will be computed that dont reach the goal in the right bottom corner
    @Test
    @Ignore
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

