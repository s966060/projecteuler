package org.fde.util.cache;

public class MatrixColumnsFirst extends Matrix {
    public MatrixColumnsFirst(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    int computeIndex(int row, int column) {
        int index = column * this.rows + row;
        return index;
    }

    @Override
    Matrix create(int rows, int columns) {
        return new MatrixColumnsFirst(rows, columns);
    }
}
