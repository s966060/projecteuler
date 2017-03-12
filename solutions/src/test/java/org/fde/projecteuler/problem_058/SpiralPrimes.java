package org.fde.projecteuler.problem_058;

import org.fde.util.matrix.Matrix;
import org.junit.Test;

import static org.fde.projecteuler.problem_058.SpiralPrimeMatrix.createSpiralPrimeMatrix;

public class SpiralPrimes {
    @Test
    public void spiralPrimes() {

    }

    @Test
    public void createOfSize_1() {
        SpiralPrimeMatrix matrix = new SpiralPrimeMatrix();

        int[][] expected = {
                {1}
        };

        SpiralPrimeMatrix expectedMatrix = createSpiralPrimeMatrix(expected);
    }

    @Test
    public void createOfSize_2() {
        SpiralPrimeMatrix matrix = new SpiralPrimeMatrix().next();

        int[][] expected = {
                {4, 3},
                {1, 2}
        };

        SpiralPrimeMatrix expectedMatrix = createSpiralPrimeMatrix(expected);
    }

    @Test
    public void createOfSize_3() {
        SpiralPrimeMatrix matrix = new SpiralPrimeMatrix().next().next();

        int[][] expected = {
                {5, 4, 3},
                {6, 1, 2},
                {7, 8, 9}
        };

        SpiralPrimeMatrix expectedMatrix = createSpiralPrimeMatrix(expected);
    }

    @Test
    public void createOfSize_5() {
        SpiralPrimeMatrix matrix = new SpiralPrimeMatrix().next().next().next();

        int[][] expected = {
                {17, 16, 15, 14, 13},
                {18,  5,  4,  3, 12},
                {19,  6,  1,  2, 11},
                {20,  7,  8,  9, 10},
                {21, 22, 23, 24, 25}
        };

        SpiralPrimeMatrix expectedMatrix = createSpiralPrimeMatrix(expected);
    }

    @Test
    public void createOfSize_7() {
        SpiralPrimeMatrix matrix = new SpiralPrimeMatrix().next().next().next().next();

        int[][] expected = {
                {37, 36, 35, 34, 33, 32, 31},
                {38, 17, 16, 15, 14, 13, 30},
                {39, 18,  5,  4,  3, 12, 29},
                {40, 19,  6,  1,  2, 11, 28},
                {41, 20,  7,  8,  9, 10, 27},
                {42, 21, 22, 23, 24, 25, 26},
                {43, 44, 45, 46, 47, 48, 49}
        };

        SpiralPrimeMatrix expectedMatrix = createSpiralPrimeMatrix(expected);
    }
}
