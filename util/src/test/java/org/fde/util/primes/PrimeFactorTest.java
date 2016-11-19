package org.fde.util.primes;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeFactorTest {
    @Test
    public void zero() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(0);

        assertEquals(ListOfLong.createListOfLong(), factors);
    }

    @Test
    public void one() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(1);

        assertEquals(ListOfLong.createListOfLong(), factors);
    }

    @Test
    public void two() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(2);

        assertEquals(ListOfLong.createListOfLong(2), factors);
    }

    @Test
    public void three() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(3);

        assertEquals(ListOfLong.createListOfLong(3), factors);
    }

    @Test
    public void four() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(4);

        assertEquals(ListOfLong.createListOfLong(2, 2), factors);
    }

    @Test
    public void five() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(5);

        assertEquals(ListOfLong.createListOfLong(5), factors);
    }

    @Test
    public void six() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(6);

        assertEquals(ListOfLong.createListOfLong(2, 3), factors);
    }

    @Test
    public void seven() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(7);

        assertEquals(ListOfLong.createListOfLong(7), factors);
    }

    @Test
    public void eight() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(8);

        assertEquals(ListOfLong.createListOfLong(2, 2, 2), factors);
    }

    @Test
    public void nine() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(9);

        assertEquals(ListOfLong.createListOfLong(3, 3), factors);
    }

    @Test
    public void ten() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(10);

        assertEquals(ListOfLong.createListOfLong(2, 5), factors);
    }

    @Test
    public void _24() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(24);

        assertEquals(ListOfLong.createListOfLong(2, 2, 2, 3), factors);
    }

    @Test
    public void perfect_number_28() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(28);

        assertEquals(ListOfLong.createListOfLong(2, 2, 7), factors);
    }

    @Test
    public void _256() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(256);

        assertEquals(ListOfLong.createListOfLong(2, 2, 2, 2, 2, 2, 2, 2), factors);
    }

    @Test
    public void _1234567890() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(1234567890);

        assertEquals(ListOfLong.createListOfLong(2, 3, 3, 5, 3607, 3803), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134043() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(134043);

        assertEquals(ListOfLong.createListOfLong(3, 7, 13, 491), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134044() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(134044);

        assertEquals(ListOfLong.createListOfLong(2, 2, 23, 31, 47), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134045() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(134045);

        assertEquals(ListOfLong.createListOfLong(5, 17, 19, 83), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134046() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(134046);

        assertEquals(ListOfLong.createListOfLong(2, 3, 3, 11, 677), factors);
    }

    @Test
    public void prime_7919() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(7919);

        assertEquals(ListOfLong.createListOfLong(7919), factors);
    }

    @Test
    public void _7920() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(7920);

        assertEquals(ListOfLong.createListOfLong(2, 2, 2, 2, 3, 3, 5, 11), factors);
    }

    @Test
    public void _7921() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(7921);

        assertEquals(ListOfLong.createListOfLong(89, 89), factors);
    }

    @Test
    public void prime_809() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(809);

        assertEquals(ListOfLong.createListOfLong(809), factors);
    }

    @Test
    public void prime_811() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(811);

        assertEquals(ListOfLong.createListOfLong(811), factors);
    }

    @Test
    public void prime_179_426_081() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(179_426_081);

        assertEquals(ListOfLong.createListOfLong(179_426_081), factors);
    }

    @Test
    public void perfect_number_33_550_336() {
        ListOfLong factors = new PrimeFactors().getPrimeFactors(33_550_336L);

        assertEquals(ListOfLong.createListOfLong(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 8191), factors);
    }
}
