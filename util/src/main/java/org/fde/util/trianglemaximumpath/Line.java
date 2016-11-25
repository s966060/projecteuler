package org.fde.util.trianglemaximumpath;

import org.fde.util.ListOfLong;

/**
 * Created by filipdelbaen on 25/11/2016.
 */
public class Line {
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
