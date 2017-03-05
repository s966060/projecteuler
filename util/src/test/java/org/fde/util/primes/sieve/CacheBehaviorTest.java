package org.fde.util.primes.sieve;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.CountingMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CacheBehaviorTest {
    @Test
    public void cacheBehaviorTest() throws Exception {
        for (int size = 1; size < 10_000; size += 10) {
            cacheBehaviorTest(size * 1000);
        }
    }

    private void cacheBehaviorTest(int size) throws Exception {
        int[] read = new int[size];
        int[] write = new int[size];

        for (int index = 0; index < read.length; ++index) {
            int value = (index + 91) % read.length;
            read[index] = value;
        }

        List<Integer> readAsList = new ArrayList<>();
        for(int index = 0; index < read.length; ++index) {
            readAsList.add(read[index]);
        }

        CountingMap<Integer> unique = new CountingMap(readAsList);
        unique.justOnce();

        for(int value = 0; value < read.length; ++value) {
            if (!unique.contains(value)) {
                String msg = String.format("does not contain (%s)", value);
                throw new Exception(msg);
            }
        }


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int runs = 0; runs < 100_000_000; ++runs) {
            int index = runs % read.length;
            int value = read[index];
            write[value] = value;
        }

        System.out.printf("size (%s) stopWatch (%s) %n", size, stopWatch);
    }
}
