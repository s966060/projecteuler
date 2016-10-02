package org.fde.projecteuler.problem_033;

class Number {
    final double value;
    final double cancelledValue;

    public Number(long value, long cancelledValue) {
        this.value = value;
        this.cancelledValue = cancelledValue;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                ", cancelledValue=" + cancelledValue +
                '}';
    }
}
