package org.fde.projecteuler.problem_049;

import org.fde.util.DigitList;
import org.fde.util.LongUtil;
import org.fde.util.primes.PrimeBuilder;
import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

class Target implements Comparable<Target> {
    private final long prime;
    private final long canonical;

    public Target(long prime, long canonical) {
        this.prime = prime;
        this.canonical = canonical;
    }

    public long getCanonical() {
        return canonical;
    }

    public long getPrime() {
        return prime;
    }

    @Override
    public String toString() {
        return "Target{" +
                "prime=" + prime +
                ", canonical=" + canonical +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Target target = (Target) o;

        if (prime != target.prime) return false;
        return canonical == target.canonical;

    }

    @Override
    public int hashCode() {
        int result = (int) (prime ^ (prime >>> 32));
        result = 31 * result + (int) (canonical ^ (canonical >>> 32));
        return result;
    }

    @Override
    public int compareTo(Target other) {
        int compare = compareCanonical(other);

        if (compare != 0) {
            return compare;
        } else {
            return comparePrime(other);
        }
    }

    int comparePrime(Target other) {
        return Long.compare(this.prime, other.prime);
    }

    int compareCanonical(Target other) {
        return Long.compare(this.canonical, other.canonical);
    }
}

class TargetSet implements Iterable<Target> {
    private final TreeSet<Target> set;

    public TargetSet() {
        this.set = new TreeSet<> ();
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
}

class TargetMap {
    private final TreeMap<Long, TargetSet> map;

    public TargetMap() {
        this.map = new TreeMap<>();
    }

    public void add(Target t) {
        if (!this.map.containsKey(t.getCanonical())) {
            this.map.put(t.getCanonical(), new TargetSet());
        }

        this.map.get(t.getCanonical()).add(t);
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

    public void forEach(BiConsumer<Long, TargetSet> action) {
        this.map.forEach(action);
    }

    public void put(Long canonical, TargetSet targets) {
        this.map.put(canonical, targets);
    }

    public int size() {
        return this.map.size();
    }
}

public class PrimePermutations {
    @Test
    public void primePermutations() {
        List<Target> suspects = getAllSuspects();
        System.out.println("suspects = " + suspects);

        TargetMap sameCanonicals = getWithSameCanonical(suspects);
        System.out.println("sameCanonicals = " + sameCanonicals);

        TargetMap atLeastThree = retainAtLeastWithThreeTargets(sameCanonicals);
        System.out.println("atLeastThree = " + atLeastThree);

        atLeastThree.forEach((canonical, targets) -> {
            Set<Long> differences = new TreeSet<>();
            final Target[] lastOne = {null};

            targets.forEach((target) -> {
                if(lastOne[0] != null) {
                    long diff = target.getPrime() - lastOne[0].getPrime();
                    differences.add(diff);
                }

                lastOne[0] = target;
            });

            if(differences.size() == 1) {
                System.out.println("targets = " + targets);
            }
        });
    }

    private TargetMap retainAtLeastWithThreeTargets(TargetMap sameCanonicals) {
        TargetMap onlyThree = new TargetMap ();

        sameCanonicals.forEach((k, v) -> {
            if(v.size() == 3) {
                onlyThree.put(k, v);
            }
        });

        return onlyThree;
    }

    private TargetMap getWithSameCanonical(List<Target> targets) {
        TargetMap sameCanonicals = new TargetMap();

        Collections.sort(targets, (one, two) -> {
            int compare = one.compareCanonical(two);

            if (compare == 0) {
                sameCanonicals.add(one);
                sameCanonicals.add(two);
            }

            return compare;
        });

        return sameCanonicals;
    }

    private List<Target> getAllSuspects() {
        List<Target> targets = new ArrayList<>();
        PrimeBuilder builder = new PrimeBuilder();

        for (long prime = builder.next(1000); prime < 10_000; prime = builder.next()) {
            DigitList digits = LongUtil.getDigits(prime);
            digits.sort();
            long canonical = digits.getValue();

            Target t = new Target(prime, canonical);
            targets.add(t);
        }

        return targets;
    }
}
