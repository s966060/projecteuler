package org.fde.projecteuler.problem_061.try2;

import org.fde.util.ListOfLong;

import java.util.Map;
import java.util.TreeMap;

public abstract class Container {
    private Map<Long, ListOfLong> map;

    public Container() {
        this.map = new TreeMap<>();
    }

    public void add(long value) {
        if (value >= 1_000 && value < 10_000) {
            Long key = computeKey(value);

            ListOfLong values = this.map.get(key);

            if (values == null) {
                values = new ListOfLong();
                this.map.put(key, values);
            }

            values.add(value);
        } else {
            throw new IllegalArgumentException("" + value);
        }
    }

    abstract long computeKey(long value);
}
