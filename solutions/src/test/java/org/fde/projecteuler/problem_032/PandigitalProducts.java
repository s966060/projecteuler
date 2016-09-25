package org.fde.projecteuler.problem_032;

import org.fde.util.ListOfLong;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PandigitalProducts {
    @Test
    public void pandigitalProducts() {
        Set<Long> products = new HashSet<>();

        for (long multiplicant = 1; multiplicant <= 999; ++multiplicant) {
            for (long multiplier = 1; multiplier <= 9999; ++multiplier) {
                long product = multiplicant * multiplier;

                String asString = "" + multiplicant + "" + multiplier + "" + product;

                if (isPandigital(asString)) {
                    System.out.println(multiplicant + " * " + multiplier + " = " + product);
                    products.add(product);
                }
            }
        }

        ListOfLong productsAsListOfLong = new ListOfLong(products);
        long sumOfProducts = productsAsListOfLong.getSum();
        System.out.println("sumOfProducts = " + sumOfProducts);
        assertEquals(45228L, sumOfProducts);
    }

    private boolean isPandigital(final String pandigital) {
        if (pandigital.length() == 9) {
            if (!pandigital.contains("0")) {
                for (int digit = 1; digit <= 9; ++digit) {
                    if (!pandigital.contains(String.valueOf(digit))) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }
}
