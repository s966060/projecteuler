package org.fde.projecteuler.problem_058;

import org.fde.util.ListOfLong;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.spiral_matrix.SpiralDiagonal;
import org.junit.Test;

public class SpiralPrimes {
    @Test
    public void spiralPrimes() {
        PrimeBuilder primes = new PrimeBuilder();
        SpiralDiagonal diagonal = new SpiralDiagonal();

        boolean done = false;
        int size = 3;

        while(!done) {
            ListOfLong values = diagonal.compute(size);

            double primeCount = 0;

            for(Long value : values) {
                if(primes.isPrime(value)) {
                    ++primeCount;
                }
            }

            double primeRatio = primeCount / values.size();

            if((size % 101) == 0) {
                System.out.println("size = " + size);
                System.out.println("primeRatio = " + primeRatio);
            }

            if(primeRatio < 0.1) {
                done = true;
            }
            else {
                size += 2;
            }
        }

        System.out.println("size = " + size);
    }
}
