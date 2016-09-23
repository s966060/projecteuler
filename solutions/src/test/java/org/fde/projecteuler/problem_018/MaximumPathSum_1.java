package org.fde.projecteuler.problem_018;

import org.apache.commons.lang3.Validate;
import org.fde.util.ClassUtil;
import org.fde.util.LineReader;
import org.fde.util.ListOfLong;
import org.fde.util.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

class Line {
    private final ListOfLong line;

    public Line() {
        this.line = new ListOfLong();
    }

    public Line(Line line) {
        this.line = new ListOfLong(line.line);
    }

    public int size() {
        return this.line.size();
    }

    public void add(long value) {
        this.line.add(value);
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }

    public long get(int index) {
        return line.get(index);
    }
}

class Triangle {
    private Stack<Line> lines;

    public Triangle() {
        this.lines = new Stack<>();
        this.lines.push(new Line());
    }

    public Triangle(Triangle other) {
        this.lines = new Stack();

        for (Line line : other.lines) {
            this.lines.push(new Line(line));
        }
    }

    public void add(Line line) {
        Validate.isTrue(this.lines.peek().size() + 1 == line.size());
        this.lines.push(line);
    }

    public Line getLastLine() {
        Line line = this.lines.peek();
        return line;
    }

    private boolean hasTwoLastLines() {
        boolean hasTwoLastLines = this.lines.size() >= 3;
        return hasTwoLastLines;
    }

    public Line getNextToLastLine() {
        Line line = this.lines.get(lines.size() - 2);
        return line;
    }

    public boolean canRollUp() {
        return hasTwoLastLines();
    }

    public Triangle rollUp() {
        if (canRollUp()) {
            Line last = getLastLine();
            Line nextToLast = getNextToLastLine();

            Line newLine = new Line();

            for (int i = 0; i < nextToLast.size(); ++i) {
                long value = nextToLast.get(i);

                long valueChildOne = last.get(i);
                long valueChildTwo = last.get(i + 1);

                long sum = value + Math.max(valueChildOne, valueChildTwo);
                newLine.add(sum);
            }

            Triangle newTriangle = new Triangle(this);
            newTriangle.removeLastLine();
            newTriangle.removeLastLine();
            newTriangle.add(newLine);

            return newTriangle;
        } else {
            return this;
        }
    }

    private void removeLastLine() {
        this.lines.pop();
    }

    @Override
    public String toString() {
        String result = "";

        for (Line line : lines) {
            result += String.format("%s%n", line);
        }

        return result;
    }

    public long getTopValue() {
        return this.lines.get(1).get(0);
    }
}

public class MaximumPathSum_1 {
    @Test
    public void maximumPathSum_1() throws Exception {
        InputStream is = ClassUtil.getInputStream(this, "triangle.txt");
        Validate.notNull(is);

        final Triangle triangle = new Triangle();

        new LineReader(is) {
            @Override
            public void readLine(String input) throws Exception {
                Scanner scanner = new Scanner(input);

                Line line = new Line();

                while (scanner.hasNextInt()) {
                    line.add(scanner.nextInt());
                }

                triangle.add(line);
            }
        }.readAll();

        Logger.log("triangle = " + triangle);
        Logger.log();
        Logger.log();

        Triangle newTriangle = new Triangle(triangle);

        while (newTriangle.canRollUp()) {
            newTriangle = newTriangle.rollUp();

            Logger.log("newTriangle = " + newTriangle);
            Logger.log();
            Logger.log();
        }

        assertEquals(1074, newTriangle.getTopValue());
    }
}
