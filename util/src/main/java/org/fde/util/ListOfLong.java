package org.fde.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by filip on 2/09/2016.
 */
public class ListOfLong {
    private final List<Long> numbers;

    public ListOfLong() {
        this.numbers = new ArrayList<>();
    }

    public void add(Long number) {
        this.numbers.add(number);
    }

    public long getSum() {
        long sum = 0;

        for (Long number : numbers) {
            sum += number;
        }

        return sum;
    }

    public long getProduct() {
        long product = 0;

        for (Long number : numbers) {
            product *= number;
        }

        return product;
    }

    public void sort() {
        Collections.sort(this.numbers);
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

    public void removeLast() {
        if (!isEmpty()) {
            this.numbers.remove(this.numbers.size() - 1);
        }
    }
}
