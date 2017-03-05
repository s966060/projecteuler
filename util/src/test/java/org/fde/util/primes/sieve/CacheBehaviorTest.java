package org.fde.util.primes.sieve;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.CountingMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CacheBehaviorTest {
    @Test
    public void cacheBehaviorTest() throws Exception {
        for(int iterations = 0; iterations < 10; ++iterations) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println();

            for (int size = 0; size < 20; ++size) {
                int arraySize = (int) Math.pow(2, size) * 128;
                cacheBehaviorTest(arraySize);
            }

            System.out.println();
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        }
    }

    private void cacheBehaviorTest(int size) throws Exception {
        int[] read = new int[size];
        int[] write = new int[size];

        for (int index = 0; index < read.length; ++index) {
            long value = (3769 * (long) index) % read.length;

            if (value < 0) {
                String msg = String.format("value (%s) > 0", value);
                throw new IllegalArgumentException(msg);
            }

            read[index] = (int) value;
        }

        // checkUnique(read);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (long runs = 0; runs < 100_000_000L; ++runs) {
            long index = runs % read.length;
            int value = read[(int) index];
            write[value] = value;
        }

        System.out.printf("size (%s) stopWatch (%s) %n", size, stopWatch);
    }

    private void checkUnique(int[] read) throws Exception {
        List<Integer> readAsList = new ArrayList<>(read.length);
        for (int index = 0; index < read.length; ++index) {
            readAsList.add(read[index]);
        }

        CountingMap<Integer> unique = new CountingMap(readAsList);
        unique.justOnce();

        for (int value = 0; value < read.length; ++value) {
            if (!unique.contains(value)) {
                String msg = String.format("does not contain (%s)", value);
                throw new Exception(msg);
            }
        }
    }
}
