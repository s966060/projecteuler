package org.fde.util.spiral_matrix;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpiralDiagonalTest {
    @Test
    public void spiralDiagonalTest() {
        SpiralMatrix matrix = new SpiralMatrix();

        for (int i = 0; i < 100; ++i) {
            int size = matrix.getSize();

            ListOfLong expected = matrix.getDiagonalValues();
            expected.sort();

            SpiralDiagonal spiralDiagonal = new SpiralDiagonal();
            ListOfLong actual = spiralDiagonal.compute(size);
            actual.sort();

            assertEquals(expected, actual);

            matrix = matrix.next();
        }
    }
}
