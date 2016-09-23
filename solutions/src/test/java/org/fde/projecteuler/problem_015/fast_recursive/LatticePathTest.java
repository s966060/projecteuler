package org.fde.projecteuler.problem_015.fast_recursive;

import org.fde.projecteuler.problem_15.fast_recursive.FindRoutes;
import org.fde.projecteuler.problem_15.fast_recursive.Lattice;
import org.fde.util.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LatticePathTest {
    @Test
    public void amountOfRoutesIn_20_x_20_Grid() {
        Lattice lattice = new Lattice(20, 20);
        long result = new FindRoutes().findRoute(lattice);

        Logger.log("msg = " + "lattice = " + lattice + " : " + result);
        assertEquals(137846528820L, result);
    }
}
