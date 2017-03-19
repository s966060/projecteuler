package org.fde.util.permutations.factory;

import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.ListOfLong;
import org.fde.util.StopWatchUtil;
import org.fde.util.permutations.PermutationList;
import org.junit.Test;

public class OrderedPermutationFactoryPerformanceTest {
    @Test
    public void orderedPermutationFactoryPerformanceTest() {
        StopWatch stopWatch = StopWatchUtil.createAndStart();

        ListOfLong input = new ListOfLong();

        for(int value = 0; value < 10; ++value) {
            input.add(value);
        }

        OrderedPermutationFactory factory = new OrderedPermutationFactory(input);

        PermutationList list = factory.getPermutations();
        int count = list.size();

        System.out.println("stopWatch = " + stopWatch);
        System.out.println("count = " + count);
    }
}
