package org.fde.projecteuler.problem_061.try2;

public class PostfixContainer extends Container {
    @Override
    long computeKey(long value) {
        long key = value % 100;
        return key;
    }
}
