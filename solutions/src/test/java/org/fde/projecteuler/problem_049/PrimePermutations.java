package org.fde.projecteuler.problem_049;

import org.fde.util.DigitList;
import org.fde.util.LongUtil;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.out;

public class PrimePermutations {
    @Test
    public void primePermutations() {
        List<Target> suspects = getAllSuspects();
        out.println("suspects = " + suspects);

        TargetMap sameCanonicals = getWithSameCanonical(suspects);
        out.println("sameCanonicals = " + sameCanonicals);

        TargetMap atLeastThree = retainAtLeastWithThreeTargets(sameCanonicals);
        out.println("atLeastThree = " + atLeastThree);

        atLeastThree.forEach((canonical, targets) -> {
            TargetMap differences[] = {new TargetMap()};

            targets.forEach((target) -> {
                targets.forEach((otherTarget) -> {
                    if (!target.equals(otherTarget)) {

                    }
                });
            });
        });
    }

    private TargetMap retainAtLeastWithThreeTargets(TargetMap sameCanonicals) {
        TargetMap onlyThree = new TargetMap();

        sameCanonicals.forEach((k, v) -> {
            if (v.size() == 3) {
                onlyThree.put(k, v);
            }
        });

        return onlyThree;
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
