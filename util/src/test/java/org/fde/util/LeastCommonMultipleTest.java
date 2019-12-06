package org.fde.util;

import org.junit.Test;

import static org.fde.util.LeastCommonMultiple.lcm;
import static org.junit.Assert.assertEquals;

public class LeastCommonMultipleTest {
    @Test
    public void test_1() {
        assertEquals(1, lcm(1, 1));
        assertEquals(10, lcm(2, 5));
        assertEquals(4, lcm(4, 4));
        assertEquals(30, lcm(10, 15));
        assertEquals(21, lcm(3, 7));
        assertEquals(12, lcm(4, 6));
        assertEquals(4950, lcm(450, 330));
    }
}
