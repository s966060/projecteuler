package com.fde;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private List<Integer> factors;

    public Product() {
        this.factors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Product{" +
                "factors=" + factors +
                ", total=" + getTotal() +
                '}';
    }

    public long getTotal() {
        long total = 1;

        for (Integer factor : factors) {
            total *= factor;
        }

        return total;
    }

    public void addFactor(int factor) {
        factors.add(factor);
    }
}
