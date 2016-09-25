package org.fde.projecteuler.problem_015.fast_recursive;

import static org.apache.commons.math3.util.CombinatoricsUtils.binomialCoefficient;

public class Lattice {
    private final int rows;
    private final int columns;

    public Lattice(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public long getRoutes() {
        long routes = binomialCoefficient(rows + columns, rows);
        return routes;
    }

    @Override
    public String toString() {
        return "Lattice{" +
                "rows=" + rows +
                ", columns=" + columns +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lattice lattice = (Lattice) o;

        if (rows != lattice.rows) return false;
        return columns == lattice.columns;

    }

    @Override
    public int hashCode() {
        int result = rows;
        result = 31 * result + columns;
        return result;
    }
}
