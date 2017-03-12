package org.fde.util.matrix;

import java.util.Arrays;

public abstract class Matrix {
    final int rows;
    final int columns;
    private double[] matrix;

    Matrix(int rows, int columns) {
        this.matrix = new double[rows * columns];
        this.rows = rows;
        this.columns = columns;
    }

    public void add(Matrix other) {
        if (this.rows == other.rows && this.columns == other.columns) {
            Matrix result = create(this.rows, columns);

            for (int row = 0; row < this.rows; ++row) {
                for (int column = 0; column < this.columns; ++column) {
                    double value = get(row, column) + get(row, column);
                    result.set(row, column, value);
                }
            }
        } else {
            String msg;
            msg = "Cannot add (%s, %s) and (%s, %s)";
            msg = String.format(msg, this.rows, this.columns, other.rows, other.columns);

            throw new IllegalArgumentException(msg);
        }
    }

    public void multiply(Matrix other) {
        if (this.rows == other.columns && this.columns == other.rows) {
            Matrix result = create(this.rows, other.columns);

            for (int row = 0; row < this.rows; ++row) {
                for (int column = 0; column < this.columns; ++column) {
                    double totalValue = 0.0;

                    for(int index = 0; index < this.columns; ++index) {
                        double cellValue = get(row, index) * other.get(index, column);
                        totalValue += cellValue;
                    }

                    result.set(row, column, totalValue);
                }
            }

        } else {
            String msg;
            msg = "Cannot multiply (%s, %s) and (%s, %s)";
            msg = String.format(msg, this.rows, this.columns, other.rows, other.columns);

            throw new IllegalArgumentException(msg);
        }
    }

    public double get(int row, int column) {
        int index = computeIndex(row, column);
        return matrix[index];
    }

    public void set(int row, int column, double value) {
        int index = computeIndex(row, column);
        matrix[index] = value;
    }

    abstract int computeIndex(int row, int column);
    abstract Matrix create(int rows, int columns);

    public static Matrix createMatrixRowsFirst(int rows, int columns) {
        return new MatrixRowsFirst(rows,columns);
    }

    public static Matrix createMatrixColumnsFirst(int rows, int columns) {
        return new MatrixColumnsFirst(rows,columns);
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matrix matrix1 = (Matrix) o;

        if (rows != matrix1.rows) return false;
        if (columns != matrix1.columns) return false;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        int result = rows;
        result = 31 * result + columns;
        result = 31 * result + Arrays.hashCode(matrix);
        return result;
    }
}
