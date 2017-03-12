package org.fde.projecteuler.problem_058;

import org.fde.util.ListOfLong;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.spiral_matrix.SpiralMatrix;
import org.junit.Test;

public class SpiralPrimes {
    @Test
    public void spiralPrimes() {
        PrimeBuilder primes = new PrimeBuilder();
        SpiralMatrix matrix = new SpiralMatrix().next();

        boolean done = false;

        while(!done) {
            ListOfLong values = matrix.getDiagonalValues();

            double primeCount = 0;

            for(Long value : values) {
                if(primes.isPrime(value)) {
                    ++primeCount;
                }
            }

            double primeRatio = primeCount / values.size();

            System.out.println("matrix.getSize() = " + matrix.getSize());
            System.out.println("primeRatio = " + primeRatio);

            if(primeRatio < 0.1) {
                done = true;
            }
            else {
                matrix = matrix.next();
            }
        }

        System.out.println("matrix.getSize() = " + matrix.getSize());
    }
}
