package org.fde.util.primes;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class PrimeFactorTest {
    private final PrimeFactors primeFactors = new PrimeFactors();

    @Test
    public void zero() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(0);

        assertEquals(createListOfLong(), factors);
    }

    @Test
    public void one() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(1);

        assertEquals(createListOfLong(), factors);
    }

    @Test
    public void two() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(2);

        assertEquals(createListOfLong(2), factors);
    }

    @Test
    public void three() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(3);

        assertEquals(createListOfLong(3), factors);
    }

    @Test
    public void four() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(4);

        assertEquals(createListOfLong(2, 2), factors);
    }

    @Test
    public void five() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(5);

        assertEquals(createListOfLong(5), factors);
    }

    @Test
    public void six() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(6);

        assertEquals(createListOfLong(2, 3), factors);
    }

    @Test
    public void seven() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(7);

        assertEquals(createListOfLong(7), factors);
    }

    @Test
    public void eight() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(8);

        assertEquals(createListOfLong(2, 2, 2), factors);
    }

    @Test
    public void nine() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(9);

        assertEquals(createListOfLong(3, 3), factors);
    }

    @Test
    public void ten() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(10);

        assertEquals(createListOfLong(2, 5), factors);
    }

    @Test
    public void _24() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(24);

        assertEquals(createListOfLong(2, 2, 2, 3), factors);
    }

    @Test
    public void perfect_number_28() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(28);

        assertEquals(createListOfLong(2, 2, 7), factors);
    }

    @Test
    public void _256() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(256);

        assertEquals(createListOfLong(2, 2, 2, 2, 2, 2, 2, 2), factors);
    }

    @Test
    public void _1234567890() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(1234567890);

        assertEquals(createListOfLong(2, 3, 3, 5, 3607, 3803), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134043() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(134043);

        assertEquals(createListOfLong(3, 7, 13, 491), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134044() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(134044);

        assertEquals(createListOfLong(2, 2, 23, 31, 47), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134045() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(134045);

        assertEquals(createListOfLong(5, 17, 19, 83), factors);
    }

    @Test
    public void the_first_four_with_four_distinct_factors_134046() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(134046);

        assertEquals(createListOfLong(2, 3, 3, 11, 677), factors);
    }

    @Test
    public void prime_7919() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(7919);

        assertEquals(createListOfLong(7919), factors);
    }

    @Test
    public void _7920() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(7920);

        assertEquals(createListOfLong(2, 2, 2, 2, 3, 3, 5, 11), factors);
    }

    @Test
    public void _7921() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(7921);

        assertEquals(createListOfLong(89, 89), factors);
    }

    @Test
    public void prime_809() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(809);

        assertEquals(createListOfLong(809), factors);
    }

    @Test
    public void prime_811() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(811);

        assertEquals(createListOfLong(811), factors);
    }

    @Test
    public void prime_179_426_081() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(179_426_081);

        assertEquals(createListOfLong(179_426_081), factors);
    }

    @Test
    public void perfect_number_33_550_336() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(33_550_336L);

        assertEquals(createListOfLong(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 8191), factors);
    }

    @Test
    public void _1_023_286_908_188_737L() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(1_023_286_908_188_737L);
        System.out.println("factors = " + factors);
        assertEquals(createListOfLong(577, 188801, 9393281), factors);
    }

    @Test
    public void _723_573_111_879_672L () {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(723_573_111_879_672L);
        System.out.println("factors = " + factors);
        assertEquals(createListOfLong(2, 2, 2, 3, 17, 19, 29, 41, 59, 241, 5521), factors);
    }

    private PrimeFactors getPrimeFactors() {
        return primeFactors;
    }

    // damn prime take a long time ... 22 secs on my workstation
    @Test
    public void _1_746_860_020_068_409L() {
        ListOfLong factors = getPrimeFactors().getPrimeFactors(1_746_860_020_068_409L);
        System.out.println("factors = " + factors);
        assertEquals(createListOfLong(1_746_860_020_068_409L), factors);
    }
}
