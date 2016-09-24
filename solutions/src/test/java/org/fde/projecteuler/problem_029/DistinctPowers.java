package org.fde.projecteuler.problem_029;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class DistinctPowers {
    @Test
    public void distinctPowers() {
        TreeSet set = new TreeSet<>();

        for (int a = 2; a <= 100; ++a) {
            for (int b = 2; b <= 100; ++b) {
                BigDecimal result = BigDecimal.valueOf(a).pow(b);

                set.add(result);
            }
        }

        System.out.println("set.size() = " + set.size());
        System.out.println("set = " + set);
        assertEquals(9183, set.size());
    }
}
