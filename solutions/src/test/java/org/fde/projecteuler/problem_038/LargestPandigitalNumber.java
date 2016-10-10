package org.fde.projecteuler.problem_038;

import org.fde.util.ListOfLong;
import org.fde.util.LongUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class LargestPandigitalNumber {
    class Pandigital {
        private final long base;
        private final long index;
        private final long value;

        public Pandigital(long base, long index, long value) {
            this.base = base;
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pandigital{" +
                    "base=" + base +
                    ", index=" + index +
                    ", value=" + value +
                    '}';
        }

        public long getValue() {
            return value;
        }
    }

    @Test
    public void largestPandigitalNumber() {
        List<Pandigital> pandigitals = new ArrayList<>();
        ListOfLong factors = createListOfLong(2, 3, 4, 5, 6, 7, 8, 9);

        nextValue:
        for (long value = 1; value < 10_000L; ++value) {
            StringBuilder concatenated = new StringBuilder();

            concatenated.append(value);

            for (long factor : factors) {
                long product = value * factor;

                concatenated.append(product);

                if (concatenated.length() > 9) {
                    continue nextValue;
                } else if (LongUtil.isPandigital(concatenated.toString())) {
                    Pandigital p = new Pandigital(value, factor, Long.valueOf(concatenated.toString()));
                    pandigitals.add(p);
                    continue nextValue;
                }
            }
        }

        Collections.sort(pandigitals, new Comparator<Pandigital>() {
            @Override
            public int compare(Pandigital o1, Pandigital o2) {
                return -Long.compare(o1.value, o2.value);
            }
        });

        System.out.println("pandigitals = " + pandigitals);

        assertEquals(932_718_654L, pandigitals.get(0).getValue());
    }
}
