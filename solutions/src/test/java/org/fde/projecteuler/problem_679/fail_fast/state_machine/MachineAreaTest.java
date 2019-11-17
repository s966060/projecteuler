package org.fde.projecteuler.problem_679.fail_fast.state_machine;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MachineAreaTest {
    @Test
    public void test_1() {
        String sentence = "AREA AREA AREA AREA";
        int count = test(sentence);
        assertEquals(4, count);
    }

    @Test
    public void test_2() {
        String sentence = "AREAREAREAREA";
        int count = test(sentence);
        assertEquals(4, count);
    }

    @Test
    public void test_3() {
        String sentence = "ARAREAREARA";
        int count = test(sentence);
        assertEquals(2, count);
    }

    @Test
    public void test_4() {
        String sentence = "AREAAREA";
        int count = test(sentence);
        assertEquals(2, count);
    }

    @Test
    public void test_5() {
        String sentence = "AREARAREA";
        int count = test(sentence);
        assertEquals(2, count);
    }

    private int test(String sentence) {
        MachineArea machine = new MachineArea();
        machine.push(sentence);
        Cursor<MachineArea.State> cursor = machine.getCurrentCursor();
        return cursor.getCount();
    }
}
