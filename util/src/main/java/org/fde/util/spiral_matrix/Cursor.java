package org.fde.util.spiral_matrix;

import org.fde.util.matrix.Matrix;

class Cursor {
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
        while (setValue(direction)) ;
    }
}
