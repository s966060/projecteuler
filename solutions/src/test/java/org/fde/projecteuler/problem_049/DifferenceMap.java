package org.fde.projecteuler.problem_049;

import java.util.TreeMap;
import java.util.function.BiConsumer;

class DifferenceMap {
    private final TreeMap<Long, TargetSet> map;

    DifferenceMap() {
        this.map = new TreeMap<>();
    }

    void put(long difference, Target one, Target two) {
        if (!this.map.containsKey(difference)) {
            this.map.put(difference, new TargetSet());
        }

        this.map.get(difference).add(one);
        this.map.get(difference).add(two);
    }

    void forEach(BiConsumer<Long, TargetSet> action) {
        this.map.forEach(action);
    }
}
