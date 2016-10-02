package org.fde.projecteuler.problem_006;

import org.fde.util.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfSquaresVersusSquareOfSum {
    @Test
    public void sumOfSquaresVersusSquareOfSum() {
        int max = 100;

        int sumOfSquares = 0;
        int squareOfSum = 0;

        for (int abc = 0; abc <= max; ++abc) {
            sumOfSquares += abc * abc;
            squareOfSum += abc;
        }

        squareOfSum *= squareOfSum;

        Logger.log("squareOfSum = " + squareOfSum);
        Logger.log("sumOfSquares = " + sumOfSquares);

        int difference = squareOfSum - sumOfSquares;

        Logger.log("difference = " + difference);

        assertEquals(25164150, difference);
    }
}
