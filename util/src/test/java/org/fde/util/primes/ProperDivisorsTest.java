package org.fde.util.primes;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by filip on 2/09/2016.
 */
public class ProperDivisorsTest {
    @Test
    public void zero() {
        ListOfLong divisors = new Divisors().getProperDivisors(0);
        assertEquals(0, divisors.size());
    }

    @Test
    public void one() {
        ListOfLong divisors = new Divisors().getProperDivisors(1);
        assertEquals(0, divisors.size());
    }

    @Test
    public void two() {
        ListOfLong divisors = new Divisors().getProperDivisors(2);
        assertThat(divisors, is(createListOfLong(1L)));
    }

    @Test
    public void three() {
        ListOfLong divisors = new Divisors().getProperDivisors(3);
        assertThat(divisors, is(createListOfLong(1L)));
    }

    @Test
    public void four() {
        ListOfLong divisors = new Divisors().getProperDivisors(4);
        assertThat(divisors, is(createListOfLong(1L, 2L)));
    }

    @Test
    public void twenty_eight() {
        ListOfLong divisors = new Divisors().getProperDivisors(28);
        assertThat(divisors, is(createListOfLong(1L, 2L, 4L, 7L, 14L)));
    }

    @Test
    public void hundred() {
        ListOfLong divisors = new Divisors().getProperDivisors(100);
        assertThat(divisors, is(createListOfLong(1L, 2L, 4L, 5L, 10L, 20L, 25L, 50L)));
    }
}
