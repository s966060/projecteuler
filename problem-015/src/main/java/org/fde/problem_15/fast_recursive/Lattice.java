package org.fde.problem_15.fast_recursive;

import static org.apache.commons.math3.util.CombinatoricsUtils.binomialCoefficient;

public class Lattice {
    private final int rows;
    private final int columns;
    private final int level;

    public Lattice(int rows, int columns, int level) {
        this.rows = rows;
        this.columns = columns;
        this.level = level;
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
                ", level=" + level +
                '}';
    }

    public int getLevel() {
        return level;
    }
}
