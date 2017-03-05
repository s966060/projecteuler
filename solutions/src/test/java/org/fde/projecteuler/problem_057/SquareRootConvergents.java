package org.fde.projecteuler.problem_057;

import org.fde.util.Ratio;
import org.fde.util.primes.PrimeFactors;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareRootConvergents {
    @Test
    public void squareRootConvergents() {
        PrimeFactors factors = new PrimeFactors();
        int yes = 0;

        Ratio base = new Ratio(1, 2);

        for (int iteration = 1; iteration <= 1000; ++iteration) {

            if(iteration > 1) {
                base = base.add(new Ratio(2));
                base = new Ratio(1).div(base);
                base = base.simplify(factors);
            }
                // System.out.printf("    expand (%s) base (%s) %n", expand, base);

            Ratio result;
            result = new Ratio(1).add(base);
            result = result.simplify(factors);

            System.out.printf("iteration (%s) result (%s) (%s) %n",
                    iteration, result, result.getRatioAsDouble());

            int digitsNominator = (int) Math.log10(result.getNominator());
            int digitsDenominator = (int) Math.log10(result.getDenominator());

            if(digitsNominator > digitsDenominator) {
                ++yes;
                System.out.println("   YES");
            }
            // Long.MAX_VALUE..........9_223_372_036_854_775_807L
            if(base.getDenominator() > 1_000_000_000_000_000_000L) {
                System.out.printf("@@@ SCALING FROM (%s) %n", base);
                base = new Ratio(base.getNominator() / 10, base.getDenominator() / 10);
                System.out.printf("@@@ SCALING TO (%s) %n", base);
            }
        }

        System.out.println("yes = " + yes);
        assertEquals(32, yes);
    }
}
