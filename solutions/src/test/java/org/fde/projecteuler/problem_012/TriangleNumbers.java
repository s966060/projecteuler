package org.fde.projecteuler.problem_012;

public class TriangleNumbers {
    private long number;
    private long sum;

    public TriangleNumbers() {
        this.number = 0;
        this.sum = 0;
    }

    public long next() {
        ++this.number;
        this.sum += this.number;
        return this.sum;
    }
}
