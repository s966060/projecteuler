package org.fde.problem_15;

import org.fde.util.permutations.PermutationFactory;
import org.fde.util.permutations.PermutationList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LatticePathTest {
    @Test
    public void amountOfRoutesIn_20_x_20_Grid() {
        List<Long> elements = Arrays.asList(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L, 2L);
        PermutationList routes = new PermutationFactory(elements).getPermutations();

        System.out.println("routes = " + routes);
        System.out.println("routes.size() = " + routes.size());
    }
}
