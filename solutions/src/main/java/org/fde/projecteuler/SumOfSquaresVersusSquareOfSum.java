package org.fde.projecteuler;

import org.fde.util.Logger;

public class SumOfSquaresVersusSquareOfSum {
    public static void main(String[] args) {
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
    }
}
