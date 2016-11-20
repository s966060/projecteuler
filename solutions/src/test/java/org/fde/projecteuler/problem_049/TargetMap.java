package org.fde.projecteuler.problem_049;

import java.util.TreeMap;
import java.util.function.BiConsumer;

class TargetMap {
    private final TreeMap<Long, TargetSet> map;

    TargetMap() {
        this.map = new TreeMap<>();
    }

    void add(Target t) {
        if (!containsKey(t.getCanonical())) {
            put(t.getCanonical(), new TargetSet());
        }

        get(t.getCanonical()).add(t);
    }

    private TargetSet get(long canonical) {
        return this.map.get(canonical);
    }

    private boolean containsKey(long canonical) {
        return this.map.containsKey(canonical);
    }

    @Override
    public String toString() {
        final String[] toString = {""};
        toString[0] += String.format("TargetMap{%n");
        toString[0] += String.format("    size = %s%n", size());

        forEach((canonical, targets) -> {
            toString[0] += String.format("    canonical = %s%n", canonical);

            for (Target t : targets) {
                toString[0] += String.format("        target = %s%n", t);
            }
        });

        toString[0] += String.format(")%n");
        return toString[0];
    }

    void forEach(BiConsumer<Long, TargetSet> action) {
        this.map.forEach(action);
    }

    void put(Long canonical, TargetSet targets) {
        this.map.put(canonical, targets);
    }

    int size() {
        return this.map.size();
    }
}
