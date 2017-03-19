package org.fde.util.combinations.iterator;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.StopWatchUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fde.util.combinations.iterator.GenericCombinationIteratorFactory.createGenericAllCombinationIterator;
import static org.junit.Assert.assertEquals;

public class GenericCombinationIteratorPerformanceTest {
    @Test
    public void combinationFactoryPerformanceTest() {
        StopWatch stopWatch = StopWatchUtil.createAndStart();

        List<Long> input = new ArrayList<>();

        for (long value = 0; value < 23; ++value) {
            input.add(value);
        }

        GenericCombinationIterator<Long> iterator
                = createGenericAllCombinationIterator(input);

        int count = 0;

        while(iterator.hasNext()) {
            iterator.next();
            ++count;
        }

        System.out.println("stopWatch = " + stopWatch);
        System.out.println("count = " + count);

        assertEquals(8_388_608, count);
    }
}
