package com.fde.problem_011;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final List<Long> factors;

    public Product() {
        this.factors = new ArrayList<>();
    }

    public void add(long factor) {
        this.factors.add(factor);
    }

    public int size() {
        return this.factors.size();
    }

    public long getProduct() {
        long product = 1;

        for(Long factor: factors) {
            product *= factor;
        }

        return product;
    }

    @Override
    public String toString() {
        return "Product{" +
                "factors=" + factors + "; product=" + getProduct() +
                '}';
    }
}
