package org.fde.projecteuler.problem_055;

import org.junit.Test;

import static org.junit.Assert.*;

public class LyrchelValidatorTest {
    @Test
    public void countAllLyrchelNumbersUpTo10000() {
        int lyrchelCounter = 0;

        for (int i = 0; i < 10000; ++i) {
            LyrchelResult result = new LyrchelValidator(50).validate(i);

            // System.out.println("result = " + result);

            if (result.isLyrchel()) {
                ++lyrchelCounter;
            }
        }

        System.out.println("lyrchelCounter = " + lyrchelCounter);
        assertEquals(249, lyrchelCounter);
    }

    @Test
    public void test_47() {
        LyrchelResult result = test(47);
        assertFalse(result.isLyrchel());
        System.out.println("result = " + result);
    }

    @Test
    public void test_349() {
        LyrchelResult result = test(349);
        assertFalse(result.isLyrchel());
        System.out.println("result = " + result);
    }

    @Test
    public void test_10677() {
        LyrchelResult result = test(10677);
        assertFalse(result.isLyrchel());
        System.out.println("result = " + result);
    }

    @Test
    public void test_196() {
        LyrchelResult result = test(196);
        assertTrue(result.isLyrchel());
        System.out.println("result = " + result);
    }

    private LyrchelResult test(int value) {
        LyrchelValidator validator = new LyrchelValidator(100);
        return validator.validate(value);
    }
}
