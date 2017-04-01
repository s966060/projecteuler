package org.fde.projecteuler.problem_062;

import org.fde.util.Digits;

class Node {
    Digits digits;
    long number;
    long cube;

    Node(Digits digits, long number, long cube) {
        this.digits = digits;
        this.number = number;
        this.cube = cube;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number=" + number +
                ", cube=" + cube +
                '}';
    }
}
