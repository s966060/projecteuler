package org.fde.projecteuler.problem_028;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by filipdelbaen on 23/09/16.
 */
public class NumberSpiralSquareTest {
    @Test
    public void sizeOne() {
        Size size = new Size(1);
        assertEquals(1, getDiagonalSum(size));
    }

    @Test
    public void sizeThree() {
        Size size = new Size(3);
        assertEquals(25, getDiagonalSum(size));
    }

    @Test
    public void sizeFive() {
        Size size = new Size(5);
        assertEquals(101, getDiagonalSum(size));
    }

    @Test
    public void sizeSeven() {
        Size size = new Size(7);
        assertEquals(261, getDiagonalSum(size));
    }

    private long getDiagonalSum(Size size) {
        return new NumberSpiralSquare(size).getDiagonalSum();
    }
}
