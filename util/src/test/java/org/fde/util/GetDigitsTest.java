package org.fde.util;

import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.fde.util.LongUtil.getDigits;
import static org.junit.Assert.assertEquals;

public class GetDigitsTest {
    @Test
    public void zero() {
        assertEquals(createListOfLong(0), getDigits(0));
    }

    @Test
    public void one() {
        assertEquals(createListOfLong(1), getDigits(1));
    }

    @Test
    public void two() {
        assertEquals(createListOfLong(2), getDigits(2));
    }

    @Test
    public void ten() {
        assertEquals(createListOfLong(1, 0), getDigits(10));
    }

    @Test
    public void eleven() {
        assertEquals(createListOfLong(1, 1), getDigits(11));
    }

    @Test
    public void twelve() {
        assertEquals(createListOfLong(1, 2), getDigits(12));
    }

    @Test
    public void hundred() {
        assertEquals(createListOfLong(1, 0, 0), getDigits(100));
    }

    @Test
    public void _123() {
        assertEquals(createListOfLong(1, 2, 3), getDigits(123));
    }

    @Test
    public void _987() {
        assertEquals(createListOfLong(9, 8, 7), getDigits(987));
    }

    @Test
    public void _987654321012345678() {
        assertEquals(
                createListOfLong(9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8),
                getDigits(987654321012345678L));
    }
}
