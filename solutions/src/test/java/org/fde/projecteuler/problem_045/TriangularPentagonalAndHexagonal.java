package org.fde.projecteuler.problem_045;

import org.fde.util.figurativenumbers.HexagonalNumberGenerator;
import org.fde.util.figurativenumbers.PentagonalNumberGenerator;
import org.fde.util.figurativenumbers.TriangleNumberGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by filipdelbaen on 08/11/2016.
 */
public class TriangularPentagonalAndHexagonal {
    @Test
    public void triangularPentagonalAndHexagonal() {
        TriangleNumberGenerator t = new TriangleNumberGenerator();
        PentagonalNumberGenerator p = new PentagonalNumberGenerator();
        HexagonalNumberGenerator h = new HexagonalNumberGenerator();

        Long target = null;
        int done = 0;

        for (int i = 1; done < 3; ++i) {
            long number = t.getByIndex(i);

            if (p.isFigurativeNumber(number)) {
                if (h.isFigurativeNumber(number)) {
                    System.out.println("number = " + number);
                    ++done;
                    target = number;
                }
            }
        }

        assertEquals(1533776805L, target.longValue());
    }
}
