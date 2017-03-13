package org.fde.projecteuler.problem_058;

import javafx.scene.paint.Stop;
import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.primes.PrimeBuilder;
import org.fde.util.spiral_matrix.SpiralDiagonal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpiralPrimes {
    @Test
    public void spiralPrimes() {
        PrimeBuilder primes = new PrimeBuilder();
        SpiralDiagonal diagonal = new SpiralDiagonal();
        diagonal.next();

        boolean done = false;
        double primeCount = 0;

        StopWatch generalStopWatch = new StopWatch();
        StopWatch primeStopWatch = new StopWatch();

        generalStopWatch.start();

        primeStopWatch.start();
        primeStopWatch.suspend();

        while(!done) {
            ListOfLong values = diagonal.getNewOnes();

            primeStopWatch.resume();

            for(Long value : values) {
                if(primes.isPrime(value)) {
                    ++primeCount;
                }
            }
            primeStopWatch.suspend();

            double primeRatio = primeCount / diagonal.getDiagonal().size();

            if((diagonal.getSize() % 101) == 0) {
                System.out.println(
                        "diagonal.getSize() = " + diagonal.getSize() +
                        " - " +
                        "primeRatio = " + primeRatio);

                System.out.println("primeStopWatch = " + primeStopWatch);
                System.out.println("generalStopWatch = " + generalStopWatch);
            }

            if(primeRatio < 0.1) {
                done = true;
            }
            else {
                diagonal.next();
            }
        }

        System.out.println("primeStopWatch = " + primeStopWatch);
        System.out.println("generalStopWatch = " + generalStopWatch);

        System.out.println("diagonal.getSize() = " + diagonal.getSize());

        assertEquals(26241, diagonal.getSize());
    }
}
