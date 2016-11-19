package org.fde.util;

import org.junit.Test;

import static org.fde.util.DigitList.createDigitList;
import static org.fde.util.ListOfLong.createListOfLong;
import static org.fde.util.LongUtil.getDigits;
import static org.junit.Assert.assertEquals;

public class GetDigitsTest {
    @Test
    public void zero() {
        assertEquals(createDigitList(0), getDigits(0));
    }

    @Test
    public void one() {
        assertEquals(createDigitList(1), getDigits(1));
    }

    @Test
    public void two() {
        assertEquals(createDigitList(2), getDigits(2));
    }

    @Test
    public void ten() {
        assertEquals(createDigitList(1, 0), getDigits(10));
    }

    @Test
    public void eleven() {
        assertEquals(createDigitList(1, 1), getDigits(11));
    }

    @Test
    public void twelve() {
        assertEquals(createDigitList(1, 2), getDigits(12));
    }

    @Test
    public void hundred() {
        assertEquals(createDigitList(1, 0, 0), getDigits(100));
    }

    @Test
    public void _123() {
        assertEquals(createDigitList(1, 2, 3), getDigits(123));
    }

    @Test
    public void _987() {
        assertEquals(createDigitList(9, 8, 7), getDigits(987));
    }

    @Test
    public void _987654321012345678() {
        assertEquals(
                createDigitList(9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8),
                getDigits(987654321012345678L));
    }
}
