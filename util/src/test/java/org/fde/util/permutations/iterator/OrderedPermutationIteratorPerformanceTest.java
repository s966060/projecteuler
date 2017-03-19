package org.fde.util.permutations.iterator;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.junit.Test;

import static org.fde.util.permutations.iterator.OrderedPermutationIterator.createOrderedPermutationIterator;

public class OrderedPermutationIteratorPerformanceTest {
    @Test
    public void orderedPermutationIteratorPerformanceTest() {
        StopWatch stopWatch = StopWatchUtil.createAndStart();

        ListOfLong input = new ListOfLong();

        for (int value = 0; value < 10; ++value) {
            input.add(value);
        }

        OrderedPermutationIterator iterator = createOrderedPermutationIterator(input);

        int count = 0;

        while (iterator.hasNext()) {
            iterator.next();
            ++count;
        }

        System.out.println("stopWatch = " + stopWatch);
        System.out.println("count = " + count);
    }
}
