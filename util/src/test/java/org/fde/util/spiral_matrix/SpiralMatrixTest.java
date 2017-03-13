package org.fde.util.spiral_matrix;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.fde.util.spiral_matrix.SpiralMatrix.createSpiralMatrix;
import static org.junit.Assert.assertEquals;

public class SpiralMatrixTest {
    @Test
    public void createOfSize_1() {
        SpiralMatrix actual = new SpiralMatrix();

        int[][] expected = {
                {1}
        };

        SpiralMatrix expectedMatrix = createSpiralMatrix(expected);

        assertEquals(expectedMatrix, actual);
    }

    @Test
    public void createOfSize_3() {
        SpiralMatrix actual = new SpiralMatrix().next();

        int[][] expected = {
                {5, 4, 3},
                {6, 1, 2},
                {7, 8, 9}
        };

        SpiralMatrix expectedMatrix = createSpiralMatrix(expected);

        assertEquals(expectedMatrix, actual);
    }

    @Test
    public void createOfSize_5() {
        SpiralMatrix actual = new SpiralMatrix().next().next();

        int[][] expected = {
                {17, 16, 15, 14, 13},
                {18,  5,  4,  3, 12},
                {19,  6,  1,  2, 11},
                {20,  7,  8,  9, 10},
                {21, 22, 23, 24, 25}
        };

        SpiralMatrix expectedMatrix = createSpiralMatrix(expected);

        assertEquals(expectedMatrix, actual);
    }

    @Test
    public void createOfSize_7() {
        SpiralMatrix actual = new SpiralMatrix().next().next().next();

        int[][] expected = {
                {37, 36, 35, 34, 33, 32, 31},
                {38, 17, 16, 15, 14, 13, 30},
                {39, 18,  5,  4,  3, 12, 29},
                {40, 19,  6,  1,  2, 11, 28},
                {41, 20,  7,  8,  9, 10, 27},
                {42, 21, 22, 23, 24, 25, 26},
                {43, 44, 45, 46, 47, 48, 49}
        };

        SpiralMatrix expectedMatrix = createSpiralMatrix(expected);

        assertEquals(expectedMatrix, actual);
    }

    @Test
    public void diagonalValues() {
        SpiralMatrix matrix = new SpiralMatrix().next().next().next();

        ListOfLong actual = matrix.getDiagonalValues();

        ListOfLong expected = createListOfLong(37, 31, 17, 13, 5, 3, 1, 9, 7, 25, 21, 49, 43);

        assertEquals(expected, actual);
    }
}
