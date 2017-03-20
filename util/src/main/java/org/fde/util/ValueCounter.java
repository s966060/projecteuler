package org.fde.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueCounter<T> {
    private Map<T, Integer> counter;

    public ValueCounter() {
        this.counter = new HashMap<T, Integer>();
    }

    public ValueCounter(List<T> values) {
        this();

        for (T value : values) {
            this.counter.put(value, 0);
        }
    }

    public void put(T value) {
        Integer count = this.counter.get(value);

        if (count == null) {
            count = 0;
        }

        count = count + 1;

        this.counter.put(value, count);
    }

    public Integer get(T value) {
        return this.counter.get(value);
    }

    public List<T> getCount(Integer target) {
        List<T> result = new ArrayList<T>();

        for (Map.Entry<T, Integer> entry : this.counter.entrySet()) {
            Integer count = entry.getValue();

            if (count.equals(target)) {
                T value = entry.getKey();
                result.add(value);
            }
        }

        return result;
    }
}
