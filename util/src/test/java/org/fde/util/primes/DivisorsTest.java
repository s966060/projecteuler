package org.fde.util.primes;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by filip on 2/09/2016.
 */
public class DivisorsTest {
    @Test
    public void zero() {
        List<Long> divisors = new Divisors().getDivisors(0);
        assertEquals(0, divisors.size());
    }

    @Test
    public void one() {
        List<Long> divisors = new Divisors().getDivisors(1);
        assertThat(asList(1L), is(divisors));
    }

    @Test
    public void two() {
        List<Long> divisors = new Divisors().getDivisors(2);
        assertThat(asList(1L, 2L), is(divisors));
    }

    @Test
    public void three() {
        List<Long> divisors = new Divisors().getDivisors(3);
        assertThat(asList(1L, 3L), is(divisors));
    }

    @Test
    public void four() {
        List<Long> divisors = new Divisors().getDivisors(4);
        assertThat(asList(1L, 2L, 4L), is(divisors));
    }

    @Test
    public void twenty_eight() {
        List<Long> divisors = new Divisors().getDivisors(28);
        assertThat(asList(1L, 2L, 4L, 7L, 14L, 28L), is(divisors));
    }

    @Test
    public void hundred() {
        List<Long> divisors = new Divisors().getDivisors(100);
        assertThat(asList(1L, 2L, 4L, 5L, 10L, 20L, 25L, 50L, 100L), is(divisors));
    }
}
