package org.fde.projecteuler.problem_060;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.commons.lang3.time.StopWatch;
import org.fde.util.StopWatchUtil;
import org.fde.util.combinations.Combination;
import org.fde.util.combinations.CombinationList;
import org.junit.Test;

public class PrimePairSets {
    @Test
    public void primePairSets() {
        StopWatch stopWatch = StopWatchUtil.createAndStart();

        CombinationList targets = new FindPrimePairSets(5).find(1000);

        System.out.println("targets = " + targets);
        System.out.println("THE END ... stopWatch = " + stopWatch);
        
        Map<Long, Combination> orderedResults = new TreeMap<>();
        
        for(Combination target : targets) {
            long sum = target.sum();
            
            orderedResults.put(sum, target);
        }
        
        for(Entry<Long, Combination> entry : orderedResults.entrySet()) {
            System.out.println(entry);
        }
    }
}
