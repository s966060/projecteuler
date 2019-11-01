package org.fde.projecteuler.problem_064;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OddPeriodSquareRoots {
    static class MyNumber {
        private final static double EPSILON = 1.0 / (1024.0 * 1024.0);

        private double number;

        public MyNumber(double number) {
            this.number = number;
        }

        public boolean isRoughlyTheSame(double other) {
            double about = Math.abs(this.number - other);

            return (0 <= about) && (about <= this.number * EPSILON);
        }

        @Override
        public String toString() {
            return "MyNumber{" +
                    "number=" + number +
                    '}';
        }
    }

    static class MyNumberList {
        private final List<MyNumber> list;

        MyNumberList() {
            this.list = new ArrayList<>();
        }

        void add(MyNumber aNumber) {
            this.list.add(aNumber);
        }

        boolean containsRoughlyTheSame(double aNumber) {
            for (MyNumber myNumber : this.list) {
                if (myNumber.isRoughlyTheSame(aNumber)) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public String toString() {
            return "MyNumberList{" + "(" + this.list.size() + "), " +
                    "list=" + list +
                    '}';
        }

        public int size() {
            return this.list.size();
        }
    }

    static class Result {
        List<Double> list;
        MyNumberList myNumberList;

        Result(List<Double> list, MyNumberList myNumberList) {
            this.list = list;
            this.myNumberList = myNumberList;
        }

        boolean isUneven() {
            int rest =  myNumberList.size() % 2;

            return (rest > 0);
        }
    }

    private Result go(int number) {
        List<Double> list = new ArrayList<>();
        MyNumberList myNumberList = new MyNumberList();

        double sqrt;
        double base;

        sqrt = Math.sqrt(number);
        base = Math.floor(sqrt);
        list.add(base);

        for (int i = 0; i < 100; ++i) {
            sqrt = 1.0 / (sqrt - base);

            if (Double.isInfinite(sqrt) || Double.isNaN(sqrt)) {
                break;
            }

            if (myNumberList.containsRoughlyTheSame(sqrt)) {
                break;
            }

            MyNumber myNumber = new MyNumber(sqrt);
            myNumberList.add(myNumber);

            base = Math.floor(sqrt);

            list.add(base);
        }

        System.out.printf("%5d = %s%n", number, list);
        System.out.printf("%5d = %s%n", number, myNumberList);

        return new Result(list, myNumberList);
    }

    @Test
    public void test_23() {
        go(23);
    }

    @Test
    public void test_10() {
        go(10);
    }

    @Test
    public void test_13() {
        go(13);
    }

    @Test
    public void test_31() {
        go(31);
    }

    @Test
    public void test() {
        int unEvenCount = 0;

        for (int i = 9900; i <= 10000; i++) {
            Result result = go(i);

            if (result.isUneven()) {
                ++unEvenCount;
            }
        }

        System.out.println("unEvenCount = " + unEvenCount);
    }
}
