package org.fde.projecteuler.problem_025;

import org.junit.Test;

import java.math.BigInteger;

public class Fibonacci_1000_Digits {
    @Test
    public void fibonacci_1000_digits() {
        BigInteger fibonacciOne = BigInteger.valueOf(1);
        BigInteger fibonacciTwo = BigInteger.valueOf(1);

        BigInteger current = BigInteger.valueOf(0);

        int index = 2;

        while (current.toString().length() < 1000) {
            ++index;
            current = fibonacciOne.add(fibonacciTwo);

            fibonacciOne = fibonacciTwo;
            fibonacciTwo = current;
        }

        System.out.println("current = " + current);
        System.out.println("index = " + index);
    }
}
