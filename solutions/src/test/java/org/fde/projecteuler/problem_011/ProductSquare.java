package org.fde.projecteuler.problem_011;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by filipdelbaen on 14/08/16.
 */
public class ProductSquare {
    private final int size;
    private final List<Integer> cells;

    public ProductSquare(int size) {
        this.size = size;
        this.cells = new ArrayList<>();
    }

    public void addCell(int number) {
        this.cells.add(number);
    }

    @Override
    public String toString() {
        String result = "";

        for (int index = 0; index < this.cells.size(); ++index) {
            if ((index > 0) && (index % size == 0)) {
                result += "\r\n";
            }

            result += String.format("%4d", this.cells.get(index));
        }

        return result;
    }

    public List<Product> getProducts(int row, int col) {
        List<Product> products = new ArrayList<>();

        products.add(getDown(row, col));
        products.add(getRight(row, col));
        products.add(getDiagonalLeft(row, col));
        products.add(getDiagonalRight(row, col));

        return products;
    }

    Product getDown(int startRow, int startColumn) {
        Product p = new Product();

        for (int row = startRow; row < startRow + 4; ++row) {
            long factor = get(row, startColumn);

            p.add(factor);
        }

        return p;
    }

    long get(int row, int col) {
        if (row >= 0 && row < this.size && col >= 0 && col < this.size) {
            int index = row * size + col;

            return this.cells.get(index);
        }

        return 0;
    }

    Product getRight(int startRow, int startColumn) {
        Product p = new Product();

        for (int column = startColumn; column < startColumn + 4; ++column) {
            long factor = get(startRow, column);

            p.add(factor);
        }

        return p;
    }

    Product getDiagonalLeft(int startRow, int startColumn) {
        Product p = new Product();

        int column = startColumn;
        int row = startRow;

        for (int index = 0; index < 4; ++index) {
            p.add(get(row, column));

            --column;
            ++row;
        }

        return p;

    }

    Product getDiagonalRight(int startRow, int startColumn) {
        Product p = new Product();

        int column = startColumn;
        int row = startRow;

        for (int index = 0; index < 4; ++index) {
            p.add(get(row, column));

            ++column;
            ++row;
        }

        return p;


    }
}
