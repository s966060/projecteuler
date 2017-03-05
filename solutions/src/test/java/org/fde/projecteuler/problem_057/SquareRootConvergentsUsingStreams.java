package org.fde.projecteuler.problem_057;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Taken from the project euler forum
 * Written by zieben46
 * Posted @ Tue, 28 Feb 2017, 03:57
 * All copyright and ownership belong to zieben46
 *
 * Not written by s966060 - just for speed comparison / study
 * Adapted to junit test format to fit in my general solution setup
 */

/*Looking at sqrt 2 expansion, there are only 2 functions used to calculate nth term:
 * 2 + 1/(x/y), and  1 + 1/(x/y).
 *
 * The first is used recursively, and second is used only once.
 *
 *  We need to find an equation that spits out a numerator and a denominator for nth term
 *
 * using algebra,
 * 2 + 1/(x/y) = (2x+y)/y
 * 1 + 1/(x/y) = (x+y)/y
 *
 * let:
 * f'(x,y) = (2x+y)/y
 * f(x,y) = (x+y)/y
 *
 * we need numerator and denominator, so we must break down f'(x,y) and f(x,y) further:
 * f'(x,y)=a'(x,y)/b'(x,y)
 * where
 * a'=2x+y
 * b'=x
 *
 * and f(x,y)=a(x,y)/b'(x,y)
 * where
 * a=x+y
 * b=x
 *
 * to find the nth term, this is the formula F(n) returns nth expansion
 *
 * F(n) = f[ f'(f'...(5,2)    )),( f'(f'...(5,2)           ))]
 *
 * where ... is a recursive step performed n times
 * to get the numerator and denominator, simply substitute f(x,y) and f'(x,y) with their
 * respective a b, a' b' counterparts
 *
 * numerator(n) = a[ a'(a'...(5,2)    )),( a'(a'...(5,2)           ))]
 * numerator(n) = b[ b'(b'...(5,2)    )),( b'(b'...(5,2)           ))]
 *
 * Now, it's just a matter a writing a program that accomplishes this.
 *
 */
public class SquareRootConvergentsUsingStreams {
    @Test

    public void squareRootConvergentsUsingStreams() {
        double thenTime = System.nanoTime();

        long actual = go();
        assertEquals(153, actual);

        double nowTime = System.nanoTime();
        System.out.println("completed in "+(nowTime - thenTime)/1000000+"ms");
    }

    private long go() {
        return Stream.iterate(2, e -> e + 1)
                .parallel()
                .limit(999)
                .map(e -> sqrtTwoEstimate(e))
                .filter(e -> numHasMoreElements(e))
                .count();
    }

    private BigInteger[] sqrtTwoEstimate(int position) {
        return sqrtTwoEstimate(new BigInteger[]{BigInteger.valueOf(5), BigInteger.valueOf(2)}, position);
    }

    private BigInteger[] sqrtTwoEstimate(BigInteger[] input, int position) {
        BigInteger num = input[0];
        BigInteger denom = input[1];
        if (position == 2) {
            BigInteger numComplete = a(num, denom);
            BigInteger denomComplete = b(num, denom);
            return new BigInteger[]{numComplete, denomComplete};
        } else {
            BigInteger numPrime = aPrime(num, denom);
            BigInteger denomPrime =  bPrime(num, denom);
            return sqrtTwoEstimate(new BigInteger[]{numPrime, denomPrime}, position-1);
        }
    }

    private BigInteger aPrime(BigInteger x, BigInteger y) {
        //return 2*x + y;
        return x.multiply(BigInteger.valueOf(2)).add(y);

    }

    private BigInteger bPrime(BigInteger x, BigInteger y) {
        return x;
    }

    private BigInteger a(BigInteger x, BigInteger y) {
        return x.add(y);
    }

    private BigInteger b(BigInteger x, BigInteger y) {
        return x;
    }

    private boolean numHasMoreElements(BigInteger[] input) {
        String numString = input[0].toString();
        String denomString = input[1].toString();
        return numString.length() > denomString.length();
    }
}
