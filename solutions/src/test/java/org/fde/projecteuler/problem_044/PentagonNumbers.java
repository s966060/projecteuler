package org.fde.projecteuler.problem_044;

import org.fde.util.figurativenumbers.PentagonalNumberGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PentagonNumbers {
    @Test
    public void pentagonNumbers() {
        PentagonalNumberGenerator x = new PentagonalNumberGenerator();

        Long D = null;

        for (int n = 1; D == null; ++n) {
            if (n % 1000 == 0) {
                System.out.println("progress ... @ n = " + n);
            }

            long one = x.getByIndex(n);

            for (int k = 1; k < n; ++k) {
                long two = x.getByIndex(k);

                long diff = one - two;

                if (x.isPentagonal(diff)) {
                    long sum = one + two;

                    if (x.isPentagonal(sum)) {
                        System.out.println("n = " + n);
                        System.out.println("k = " + k);
                        System.out.println("one = " + one);
                        System.out.println("two = " + two);
                        System.out.println("diff = " + diff);
                        System.out.println("sum = " + sum);
                        D = diff;
                    }
                }
            }
        }

        assertEquals(5482660L, D.longValue());
    }

}
