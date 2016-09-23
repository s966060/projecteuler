package org.fde.problem_14;

import org.fde.util.ListOfLong;
import org.fde.util.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColatzProblemTest {
    @Test
    public void theLargestSequenceAnyNumberUnderAMillion() {
        ListOfLong longestSequence = new ListOfLong();
        long longestSequenceNumber = 0;

        for (long number = 1L; number < 1_000_000L; ++number) {
            ListOfLong sequence = getSequence(number);

            if (sequence.size() > longestSequence.size()) {
                longestSequence = sequence;
                longestSequenceNumber = number;
            }
        }

        Logger.log("longestSequence = " + longestSequence);
        Logger.log("longestSequence.size() = " + longestSequence.size());
        Logger.log("longestSequenceNumber = " + longestSequenceNumber);

        assertEquals(525, longestSequence.size());
        assertEquals(837799, longestSequenceNumber);
    }

    private ListOfLong getSequence(long number) {
        ListOfLong sequence = new ListOfLong();

        boolean done = false;

        do {
            sequence.add(number);

            if (number == 1) {
                done = true;
            } else if ((number % 2) == 0) {
                number = number / 2;
            } else {
                number = number * 3 + 1;
            }
        } while (!done);

        return sequence;
    }
}
