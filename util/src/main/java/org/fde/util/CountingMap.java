package org.fde.util;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class CountingMap<T> {
    private final Map<T, Integer> countMap;

    public CountingMap() {
        this.countMap = new TreeMap<T, Integer>();
    }

    public CountingMap(T[] values) {
        this();

        for(T value : values) {
            add(value);
        }
    }

    public CountingMap(Collection<T> values) {
        this();

        for(T value : values) {
            add(value);
        }
    }

    public void add(T value) {
        Integer count = this.countMap.get(value);

        if(count == null) {
            count = 1;
        }

        this.countMap.put(value, count);
    }

    public void justOnce() throws Exception {
        for(Map.Entry<T, Integer> entry : this.countMap.entrySet()) {
            if(entry.getValue() != 1) {
                throw new Exception(String.format("entry (%s) is not unique."));
            }
        }
    }
}
