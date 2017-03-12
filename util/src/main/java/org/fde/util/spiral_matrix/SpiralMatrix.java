package org.fde.util.spiral_matrix;

import org.fde.util.matrix.Matrix;

import static org.fde.util.matrix.Matrix.createMatrixRowsFirst;

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

    static enum Direction {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

        private final int rowIncrement;
        private final int columnIncrement;

        Direction(int rowIncrement, int columnIncrement) {
            this.rowIncrement = rowIncrement;
            this.columnIncrement = columnIncrement;
        }
    }

    static class Cursor {
        private final Matrix matrix;

        private int rowIndex;
        private int columnIndex;

        private int value;

        public Cursor(Matrix matrix, int rowIndex, int columnIndex, int value) {
            this.matrix = matrix;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
            this.value = value;
        }

        boolean setValue(Direction direction) {
            int newRowIndex = rowIndex + direction.rowIncrement;
            int newColumnIndex = columnIndex + direction.columnIncrement;

            if (newRowIndex >= 0 && newRowIndex < matrix.getRows()) {
                if (newColumnIndex >= 0 && newColumnIndex < matrix.getColumns()) {
                    this.rowIndex = newRowIndex;
                    this.columnIndex = newColumnIndex;

                    this.matrix.set(this.rowIndex, this.columnIndex, this.value);
                    ++this.value;
                    return true;
                }
            }

            return false;
        }

        void setValues(Direction direction) {
             while(setValue(direction));
        }
    }

    public SpiralMatrix next() {
        int size = this.matrix.getRows() + 1;

        if (size == 2) {
            int[][] values = {
                    {4, 3},
                    {1, 2}
            };

            return createSpiralMatrix(
                    values
            );
        } else if (size == 3) {
            int[][] values = {
                    {5, 4, 3},
                    {6, 1, 2},
                    {7, 8, 9}
            };

            return createSpiralMatrix(
                    values
            );
        }
        else {
            // 3 -> 5; 5 -> 7; ...
            // uneven sizes from now on
            // each last element start @ right bottom
            ++size;
            Matrix newMatrix = createMatrix(size);

            int  value = (int) getRightBottomValue();

            // we start at right bottom + one to the right
            int columnIndex = size - 1;
            int rowIndex = size - 2;

            Cursor cursor = new Cursor(newMatrix, rowIndex, columnIndex, value + 1);

            cursor.setValues(Direction.RIGHT);
            cursor.setValues(Direction.UP);
            cursor.setValues(Direction.LEFT);
            cursor.setValues(Direction.DOWN);
            cursor.setValues(Direction.RIGHT);

            return new SpiralMatrix(newMatrix);
        }
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
