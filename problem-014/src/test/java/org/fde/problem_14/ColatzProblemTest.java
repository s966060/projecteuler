package org.fde.problem_14;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by filip on 18/08/2016.
 */
public class ColatzProblemTest {
    @Test
    public void theLargestSequenceAnyNumberUnderAMillion() {
        List<Long> longestSequence = Collections.emptyList();
        long longestSequenceNumber = 0;

        for(long number = 1L; number < 1_000_000L; ++number) {
            List<Long> sequence = getSequence(number);

            if(sequence.size() > longestSequence.size()) {
                longestSequence = sequence;
                longestSequenceNumber = number;
            }
        }

        System.out.println("longestSequence = " + longestSequence);
        System.out.println("longestSequence.size() = " + longestSequence.size());
        System.out.println("longestSequenceNumber = " + longestSequenceNumber);

        assertEquals(525, longestSequence.size());
        assertEquals(837799, longestSequenceNumber);
    }

    private List<Long> getSequence(long number) {
        List<Long> sequence = new ArrayList<>();

        boolean done = false;

        do {
            sequence.add(number);

            if(number == 1) {
                done = true;
            }
            else
            if((number %2) == 0) {
                number = number / 2;
            }
            else {
                number = number * 3 + 1;
            }
        } while(!done);

        return sequence;
    }
}
