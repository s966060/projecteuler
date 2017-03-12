package org.fde.util.spiral_matrix;

enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

    final int rowIncrement;
    final int columnIncrement;

    Direction(int rowIncrement, int columnIncrement) {
        this.rowIncrement = rowIncrement;
        this.columnIncrement = columnIncrement;
    }
}
