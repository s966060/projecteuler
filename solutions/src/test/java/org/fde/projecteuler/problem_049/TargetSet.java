package org.fde.projecteuler.problem_049;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * Created by filip on 20/11/2016.
 */
class TargetSet implements Iterable<Target> {
    private final TreeSet<Target> set;

    public TargetSet() {
        this.set = new TreeSet<>();
    }

    public void add(Target t) {
        this.set.add(t);
    }

    @Override
    public Iterator<Target> iterator() {
        return this.set.iterator();
    }

    @Override
    public void forEach(Consumer<? super Target> action) {
        this.set.forEach(action);
    }

    public int size() {
        return this.set.size();
    }

    @Override
    public String toString() {
        final String[] toString = {""};
        toString[0] += String.format("TargetSet{%n");
        toString[0] += String.format("    size = %s%n", size());

        forEach((target) -> {
            toString[0] += String.format("    target = %s%n", target);
        });

        toString[0] += String.format(")%n");
        return toString[0];
    }

    DifferenceMap getDifferenceMap() {
        DifferenceMap differences = new DifferenceMap();

        forEach((target) -> {
            forEach((otherTarget) -> {
                if (!target.equals(otherTarget)) {
                    long diff = Math.abs(target.getPrime() - otherTarget.getPrime());

                    differences.put(diff, target, otherTarget);
                }
            });
        });

        return differences;
    }
}
