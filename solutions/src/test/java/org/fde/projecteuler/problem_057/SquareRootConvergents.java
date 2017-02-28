package org.fde.projecteuler.problem_057;

import org.fde.util.Ratio;
import org.junit.Test;

public class SquareRootConvergents {
    @Test
    public void squareRootConvergents() {
        Ratio rr = new Ratio(1, 1).div(new Ratio(2, 1).add(new Ratio(1, 2)));
        System.out.println("rr = " + rr);
        rr.simplify();
        System.out.println("rr = " + rr);

        if(true) {
            return;
        }

        for (int iteration = 1; iteration <= 100; ++iteration) {
            for (int expand = 1; 1 <= iteration; ++expand) {
                Ratio r = new Ratio(1, 1).div(new Ratio(2, 1).add(new Ratio(1, 2)));
                System.out.println("r = " + r);
                r.simplify();
                System.out.println("r = " + r);

            }
        }
    }
}
