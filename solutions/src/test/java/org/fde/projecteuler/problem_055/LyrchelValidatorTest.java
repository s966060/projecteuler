package org.fde.projecteuler.problem_055;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LyrchelValidatorTest {
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
