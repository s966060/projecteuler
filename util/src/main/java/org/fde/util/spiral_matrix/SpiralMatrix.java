package org.fde.util.spiral_matrix;

import org.fde.util.matrix.Matrix;

import static org.fde.util.matrix.Matrix.createMatrixRowsFirst;
import static org.fde.util.spiral_matrix.Direction.*;

public class SpiralMatrix {
    private final Matrix matrix;

    public SpiralMatrix() {
        this.matrix = createMatrix(1);
        this.matrix.set(0, 0, 1);
    }

    private SpiralMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public static SpiralMatrix createSpiralMatrix(int[][] values) {
        int size = values.length;

        Matrix matrix = createMatrix(size);

        for (int rowIndex = 0; rowIndex < values.length; ++rowIndex) {
            int[] row = values[rowIndex];

            if (row.length != size) {
                String format = "Spiral matrix size (%s) violation in row (%s) length (%s)";
                String msg = String.format(format, size, rowIndex, row.length);
                throw new IllegalArgumentException(msg);
            }

            for(int columnIndex = 0; columnIndex < row.length; ++columnIndex) {
                int value = values[rowIndex][columnIndex];
                matrix.set(rowIndex, columnIndex, value);
            }
        }

        return new SpiralMatrix(matrix);
    }

    public SpiralMatrix next() {
        int size = this.matrix.getRows();

        if (size == 1) {
            return createSize_2();
        } else if (size == 2) {
            return createSize_3();
        }
        else {
            // 3 -> 5; 5 -> 7; ...
            // uneven sizes from now on
            // each last element start @ right bottom
            return create(size + 2);
        }
    }

    private SpiralMatrix create(int size) {
        Matrix newMatrix = createMatrix(size);

        copyToNewMatrix(newMatrix);

        int  value = (int) getRightBottomValue();

        // we start at right bottom + one to the right
        int columnIndex = size - 2;
        int rowIndex = size - 2;

        Cursor cursor = new Cursor(newMatrix, rowIndex, columnIndex, value + 1);

        cursor.setValues(RIGHT);
        cursor.setValues(UP);
        cursor.setValues(LEFT);
        cursor.setValues(DOWN);
        cursor.setValues(RIGHT);

        return new SpiralMatrix(newMatrix);
    }

    private void copyToNewMatrix(Matrix newMatrix) {
        for (int rowIndex = 0; rowIndex < this.matrix.getRows(); ++rowIndex) {
            for (int columnIndex = 0; columnIndex < this.matrix.getColumns(); ++columnIndex) {
                int value = (int) this.matrix.get(rowIndex, columnIndex);

                newMatrix.set(rowIndex + 1, columnIndex + 1, value);
            }
        }
    }

    private SpiralMatrix createSize_3() {
        int[][] values = {
                {5, 4, 3},
                {6, 1, 2},
                {7, 8, 9}
        };

        return createSpiralMatrix(values);
    }

    private SpiralMatrix createSize_2() {
        int[][] values = {
                {4, 3},
                {1, 2}
        };

        return createSpiralMatrix(values);
    }

    private double getRightBottomValue() {
        int index = this.matrix.getRows() - 1;
        double value = this.matrix.get(index, index);
        return value;
    }

    private static Matrix createMatrix(int size) {
        return createMatrixRowsFirst(size, size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpiralMatrix that = (SpiralMatrix) o;

        return matrix.equals(that.matrix);
    }

    @Override
    public int hashCode() {
        return matrix.hashCode();
    }

    @Override
    public String toString() {
        return "SpiralMatrix{" +
                "matrix=" + matrix +
                '}';
    }
}
