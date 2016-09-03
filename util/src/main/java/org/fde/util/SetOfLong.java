package org.fde.util;

import java.util.*;
import java.util.function.Consumer;

public class SetOfLong implements Iterable<Long> {
    private final Set<Long> numbers;

    public SetOfLong() {
        this.numbers = new HashSet<>();
    }

    public SetOfLong(SetOfLong other) {
        this.numbers = new HashSet<>(other.numbers);
    }

    public SetOfLong(Long... numbers) {
        this.numbers = new HashSet<>(Arrays.asList(numbers));
    }

    public static SetOfLong createSetOfLong(Long... numbers) {
        return new SetOfLong(numbers);
    }

    public void add(Long number) {
        this.numbers.add(number);
    }

    public long getSum() {
        long sum = 0;

        for (Long number : numbers) {
            sum += number;
        }

        return sum;
    }

    public long getProduct() {
        if (isEmpty()) {
            return 0;
        }

        long product = 1;

        for (Long number : numbers) {
            product *= number;
        }

        return product;
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

    public int size() {
        return this.numbers.size();
    }


    @Override
    public String toString() {
        return "SetOfLong{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SetOfLong that = (SetOfLong) o;

        return numbers.equals(that.numbers);

    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }

    @Override
    public Iterator<Long> iterator() {
        return this.numbers.iterator();
    }

    @Override
    public void forEach(Consumer<? super Long> action) {
        this.numbers.forEach(action);
    }

    @Override
    public Spliterator<Long> spliterator() {
        return this.numbers.spliterator();
    }
}
