package org.fde.projecteuler.problem_057;

import org.fde.util.RatioOfBigInteger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SquareRootConvergentsUsingRatioOfBigInteger {
    @Test
    public void squareRootConvergents() {
        int yes = 0;

        RatioOfBigInteger base = new RatioOfBigInteger(1, 2);

        for (int iteration = 1; iteration <= 1000; ++iteration) {

            if (iteration > 1) {
                base = base.add(new RatioOfBigInteger(2));
                base = new RatioOfBigInteger(1).div(base);
                base = base.simplify();
            }
            // System.out.printf("    expand (%s) base (%s) %n", expand, base);

            RatioOfBigInteger result;
            result = new RatioOfBigInteger(1).add(base);
            result = result.simplify();

            System.out.printf("iteration (%s) result (%s) (%s) %n",
                    iteration, result, result.getRatioAsDouble());

            int digitsNominator = result.getNominator().toString().length();
            int digitsDenominator = result.getDenominator().toString().length();

            if (digitsNominator > digitsDenominator) {
                ++yes;
                System.out.println("   YES");
            }
        }

        System.out.println("yes = " + yes);
        assertEquals(153, yes);
    }
}
