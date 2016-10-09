package org.fde.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RotateRightTest {
    @Test
    public void empty() {
        ListOfLong empty = new ListOfLong();
        empty.rotateRight();
        assertTrue(empty.isEmpty());
    }

    @Test
    public void oneElement() {
        ListOfLong one = new ListOfLong(1L);
        one.rotateRight();
        assertEquals(ListOfLong.createListOfLong(1), one);
        one.rotateRight();
        assertEquals(ListOfLong.createListOfLong(1), one);
    }

    @Test
    public void twoElements() {
        ListOfLong two = new ListOfLong(1L, 2L);
        two.rotateRight();
        assertEquals(ListOfLong.createListOfLong(2, 1), two);
        two.rotateRight();
        assertEquals(ListOfLong.createListOfLong(1, 2), two);
    }

    @Test
    public void threeElements() {
        ListOfLong three = new ListOfLong(1L, 2L,3L);
        three.rotateRight();
        assertEquals(ListOfLong.createListOfLong(3, 1, 2), three);
        three.rotateRight();
        assertEquals(ListOfLong.createListOfLong(2, 3, 1), three);
        three.rotateRight();
        assertEquals(ListOfLong.createListOfLong(1, 2, 3), three);
    }
}
