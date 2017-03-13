package org.fde.util.spiral_matrix;

import org.fde.util.ListOfLong;

public class SpiralDiagonal {
    private int size;
    private final ListOfLong diagonal;

    public SpiralDiagonal() {
        this.size = 1;
        this.diagonal = new ListOfLong();
        this.diagonal.add(1);
    }

    public void next() {
        this.size += 2;

        long value = this.size * this.size;

        for (int corner = 0; corner < 4; ++corner) {
            this.diagonal.add(value);

            int step = this.size - 1;
            value -= step;
        }
    }

    public ListOfLong getDiagonal() {
        return this.diagonal;
    }
}
