package org.fde.projecteuler.problem_062;

import org.fde.util.Digits;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CubicPermutations {
    @Test
    public void cubicPermutations() {
        MyMap map = new MyMap();

        for (long number = 100; number < 100_000; ++number) {
            long cube = number * number * number;

            Digits digits = Digits.valueOf(cube);
            digits.sort();

            Node node = new Node(digits, number, cube);
            map.put(node);
        }

        assertEquals(127_035_954_683L, map.getTarget().longValue());
    }
}
