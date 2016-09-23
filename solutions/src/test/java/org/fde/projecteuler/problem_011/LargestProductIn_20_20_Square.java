package org.fde.projecteuler.problem_011;

import org.fde.util.ClassUtil;
import org.fde.util.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by filipdelbaen on 14/08/16.
 */
public class LargestProductIn_20_20_Square {
    public static final int SIZE = 20;

    @Test
    public void main() throws Exception {
        InputStream is = ClassUtil.getInputStream(LargestProductIn_20_20_Square.class, "theSquare.txt");

        final ProductSquare square = new ProductSquare(SIZE);

        Scanner scanner = new Scanner(is);

        while (scanner.hasNextInt()) {
            square.addCell(scanner.nextInt());
        }


        Logger.log("square = \r\n" + square);

        List<Product> products = new ArrayList<>();

        for (int row = 0; row < SIZE; ++row) {
            for (int col = 0; col < SIZE; ++col) {
                products.addAll(square.getProducts(row, col));
            }
        }

        Logger.log("products = " + products);

        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -Long.compare(o1.getProduct(), o2.getProduct());
            }
        });

        Logger.log("products = " + products);

        long largestProduct = products.get(0).getProduct();
        assertEquals(70600674L, largestProduct);
    }
}
