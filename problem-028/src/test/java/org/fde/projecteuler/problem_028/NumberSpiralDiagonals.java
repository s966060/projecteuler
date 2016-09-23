package org.fde.projecteuler.problem_028;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberSpiralDiagonals {
    @Test
    public void numberSpiralDiagonals() {
        Size size = new Size(1001);
        long actual = new NumberSpiralSquare(size).getDiagonalSum();
        assertEquals(669171001L, actual);
    }
}
