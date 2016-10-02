package org.fde.projecteuler.problem_008;

import org.fde.projecteuler.Product;
import org.fde.util.ClassUtil;
import org.fde.util.LineReader;
import org.fde.util.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LargestProductInASeries {
    @Test
    public void largestProductInASeries() throws Exception {
        String thousandDigitNumber = getNumber();
        Logger.log("thousandDigitNumber = " + thousandDigitNumber.toString());

        List<Product> list = new ArrayList<>();

        for (int i = 0; i < thousandDigitNumber.length() - 13; ++i) {
            String suspect = thousandDigitNumber.substring(i, i + 13);

            Product p = new Product();

            for (int j = 0; j < suspect.length(); ++j) {
                int factor = suspect.charAt(j) - 48;
                p.addFactor(factor);
            }

            list.add(p);
        }

        Logger.log("list = " + list);

        Collections.sort(list, (o1, o2) -> {
            int compare = Long.compare(o1.getTotal(), o2.getTotal());
            return -compare;
        });

        Logger.log("list = " + list);

        assertEquals(23514624000L, list.get(0).getTotal());
    }

    private static String getNumber() throws Exception {
        StringBuilder thousandDigitNumber = new StringBuilder();

        InputStream is = ClassUtil.getInputStream(LargestProductInASeries.class, "1000-digit-number.txt");

        new LineReader(is) {
            @Override
            public void readLine(String line) throws Exception {
                thousandDigitNumber.append(line);
            }
        }.readAll();

        return thousandDigitNumber.toString();
    }
}
