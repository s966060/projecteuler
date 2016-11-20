package org.fde.projecteuler.problem_049;

import org.fde.util.DigitList;
import org.fde.util.LongUtil;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;
import static org.junit.Assert.assertTrue;

public class PrimePermutations {
    @Test
    public void primePermutations() {
        // List<Target> suspects = getAllSuspects();
        List<Target> suspects = Arrays.asList(
                new Target(1478, 1), // 1
                new Target(1487, 1), // 2
                new Target(1748, 1), // 3
                new Target(1784, 1), // 4
                new Target(1847, 1), // 5
                new Target(1874, 1), // 6

                new Target(4178, 1), // 7
                new Target(4187, 1), // 8
                new Target(4718, 1), // 9
                new Target(4781, 1), // 10
                new Target(4817, 1), // 11
                new Target(4871, 1), // 12

                new Target(7148, 1), // 13
                new Target(7184, 1), // 14
                new Target(7418, 1), // 15
                new Target(7481, 1), // 16
                new Target(7814, 1), // 17
                new Target(7841, 1), // 18

                new Target(8147, 1), // 19
                new Target(8174, 1), // 20
                new Target(8417, 1), // 21
                new Target(8471, 1), // 22
                new Target(8714, 1), // 23
                new Target(8741, 1)  // 24
        );

        // out.println("suspects = " + suspects);

        TargetMap sameCanonicals = getWithSameCanonical(suspects);
        // out.println("sameCanonicals = " + sameCanonicals);

        TargetMap atLeastThree = retainAtLeastWithThreeTargets(sameCanonicals);
        // out.println("atLeastThree = " + atLeastThree);

        atLeastThree.forEach((canonical, targets) -> {
            DifferenceMap differences = targets.getDifferenceMap();

            differences.forEach((difference, suspectTargets) -> {
                if (suspectTargets.size() > 2) {
                    out.println("difference = " + difference);
                    out.println(suspectTargets);
                }
            });
        });

        assertTrue(false); // "not solved yet"
    }

    private TargetMap retainAtLeastWithThreeTargets(TargetMap sameCanonicals) {
        TargetMap atLeastThree = new TargetMap();

        sameCanonicals.forEach((k, v) -> {
            if (v.size() >= 3) {
                atLeastThree.put(k, v);
            }
        });

        return atLeastThree;
    }

    private TargetMap getWithSameCanonical(List<Target> targets) {
        TargetMap sameCanonicals = new TargetMap();

        Collections.sort(targets, (one, two) -> {
            int compare = one.compareCanonical(two);

            if (compare == 0) {
                sameCanonicals.add(one);
                sameCanonicals.add(two);
            }

            return compare;
        });

        return sameCanonicals;
    }

    private List<Target> getAllSuspects() {
        List<Target> targets = new ArrayList<>();
        PrimeBuilder builder = new PrimeBuilder();

        for (long prime = builder.next(1000); prime < 10_000; prime = builder.next()) {
            DigitList digits = LongUtil.getDigits(prime);
            digits.sort();
            long canonical = digits.getValue();

            Target t = new Target(prime, canonical);
            targets.add(t);
        }

        return targets;
    }
}
