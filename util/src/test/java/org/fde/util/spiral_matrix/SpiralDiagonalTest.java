package org.fde.util.spiral_matrix;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpiralDiagonalTest {
    @Test
    public void spiralDiagonalTest() {
        SpiralMatrix matrix = new SpiralMatrix();
        SpiralDiagonal spiralDiagonal = new SpiralDiagonal();

        for (int i = 0; i < 100; ++i) {
            ListOfLong expected = matrix.getDiagonalValues();
            expected.sort();

            ListOfLong actual = spiralDiagonal.getDiagonal();
            actual.sort();

            assertEquals(expected, actual);

            matrix = matrix.next();
            spiralDiagonal.next();
        }
    }
}
