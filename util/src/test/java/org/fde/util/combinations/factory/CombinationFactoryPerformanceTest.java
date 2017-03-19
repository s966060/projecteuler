package org.fde.util.combinations.factory;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.fde.util.combinations.CombinationList;
import org.junit.Test;

public class CombinationFactoryPerformanceTest {
    @Test
    public void combinationFactoryPerformanceTest() {
        StopWatch stopWatch = StopWatchUtil.createAndStart();

        ListOfLong input = new ListOfLong();

        for (int value = 0; value < 23; ++value) {
            input.add(value);
        }

        CombinationFactory factory = new CombinationFactory(input);
        CombinationList list = factory.getCombinations();
        int count = list.size();

        System.out.println("stopWatch = " + stopWatch);
        System.out.println("count = " + count);
    }
}
