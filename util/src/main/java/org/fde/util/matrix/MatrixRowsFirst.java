package org.fde.util.matrix;

public class MatrixRowsFirst extends Matrix {
    public MatrixRowsFirst(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    int computeIndex(int row, int column) {
        int index = row * this.columns + column;
        return index;
    }

    @Override
    Matrix create(int rows, int columns) {
        return new MatrixRowsFirst(rows, columns);
    }
}
