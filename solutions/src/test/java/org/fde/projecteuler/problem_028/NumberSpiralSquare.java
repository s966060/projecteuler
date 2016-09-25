package org.fde.projecteuler.problem_028;

public class NumberSpiralSquare {
    private final int step;
    private Long largest;

    public NumberSpiralSquare(Size size) {
        this.step = size.getStep();
    }

    public NumberSpiralSquare(Step step) {
        this.step = step.getStep();
    }

    public long getDiagonalSum() {
        if (step == 1) {
            this.largest = 1L;
            return 1;
        }

        NumberSpiralSquare child = new NumberSpiralSquare(new Step(step - 1));

        long sumOfChild = child.getDiagonalSum();

        int side = 1 + (step - 1) * 2;
        int distance = side - 1;
        long sum = 0;
        sum += child.getLargest() + distance;
        sum += child.getLargest() + distance + distance;
        sum += child.getLargest() + distance + distance + distance;
        sum += child.getLargest() + distance + distance + distance + distance;
        sum += sumOfChild;

        this.largest = child.getLargest() + 4 * distance;

        return sum;
    }

    public Long getLargest() {
        return largest;
    }
}
