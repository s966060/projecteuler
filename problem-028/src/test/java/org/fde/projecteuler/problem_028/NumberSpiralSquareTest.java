package org.fde.projecteuler.problem_028;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by filipdelbaen on 23/09/16.
 */
public class NumberSpiralSquareTest {
    @Test
    public void sizeOne() {
        assertEquals(1, new NumberSpiralSquare(new Size(1)).getDiagonalSum());
    }

    @Test
    public void sizeThree() {
        assertEquals(25, new NumberSpiralSquare(new Size(3)).getDiagonalSum());
    }

    @Test
    public void sizeFive() {
        assertEquals(101, new NumberSpiralSquare(new Size(5)).getDiagonalSum());
    }

    @Test
    public void sizeSeven() {
        assertEquals(261, new NumberSpiralSquare(new Size(7)).getDiagonalSum());
    }
}
