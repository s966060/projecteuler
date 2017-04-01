package org.fde.projecteuler.problem_061.try2;

import org.fde.util.ListOfLong;

import java.util.Map;
import java.util.TreeMap;

abstract class Container {
    private Map<Long, ListOfLong> map;

    Container() {
        this.map = new TreeMap<>();
    }

    void add(long value) {
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

    ListOfLong get(long key) {
        ListOfLong list = this.map.get(key);

        if (list != null) {
            return list;
        } else {
            return new ListOfLong();
        }
    }
}
