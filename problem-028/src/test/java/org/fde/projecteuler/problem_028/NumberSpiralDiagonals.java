package org.fde.projecteuler.problem_028;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberSpiralDiagonals {
    @Test
    public void numberSpiralDiagonals() {
        assertEquals(1048374705L, new NumberSpiralSquare(new Size(1001)).getDiagonalSum());
    }
}
