package com.fde;

public class SumOfSquaresVersusSquareOfSum {
    public static void main(String[] args) {
        int max = 100;

        int sumOfSquares = 0;
        int squareOfSum = 0;

        for(int abc = 0; abc <= max; ++abc) {
            sumOfSquares += abc * abc;
            squareOfSum += abc;
        }

        squareOfSum *= squareOfSum;

        System.out.println("squareOfSum = " + squareOfSum);
        System.out.println("sumOfSquares = " + sumOfSquares);

        int difference = squareOfSum - sumOfSquares;

        System.out.println("difference = " + difference);
    }
}
