package org.fde.util.trianglemaximumpath;

import org.apache.commons.lang3.Validate;
import org.fde.util.Logger;

import java.util.Stack;

public class Triangle {
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

    public Triangle solveTriangle() {
        Triangle newTriangle = new Triangle(this);

        while (newTriangle.canRollUp()) {
            newTriangle = newTriangle.rollUp();

            Logger.log("newTriangle = " + newTriangle);
            Logger.log();
            Logger.log();
        }
        return newTriangle;
    }
}
