package org.fde.util;

import java.util.*;
import java.util.function.Consumer;

public class ListOfLong implements Iterable<Long> {
    private final List<Long> numbers;

    public ListOfLong() {
        this.numbers = new ArrayList<>();
    }

    public ListOfLong(ListOfLong other) {
        this.numbers = new ArrayList<>(other.numbers);
    }

    public ListOfLong(Long... numbers) {
        this.numbers = new ArrayList<>(Arrays.asList(numbers));
    }

    public ListOfLong(Long first, ListOfLong other) {
        this();
        add(first);
        addAll(other);
    }

    private ListOfLong(List<Long> other) {
        this.numbers = other;
    }

    public static ListOfLong createListOfLong(long... numbers) {
        ListOfLong result = new ListOfLong();

        for(long n : numbers) {
            result.add(Long.valueOf(n));
        }

        return result;
    }

    public static ListOfLong createListOfLong(int... numbers) {
        ListOfLong result = new ListOfLong();

        for(int n : numbers) {
            result.add(Long.valueOf(n));
        }

        return result;
    }

    public ListOfLong getUnModifiableListOfLong() {
        return new ListOfLong(Collections.unmodifiableList(this.numbers));
    }

    public void add(Long number) {
        this.numbers.add(number);
    }

    public void add(int index, Long el) {
        this.numbers.add(index, el);
    }

    public void addAll(ListOfLong other) {
        this.numbers.addAll(other.numbers);
    }

    public void addAll(Long... other) {
        this.numbers.addAll(Arrays.asList(other));
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

    public void sort() {
        Collections.sort(this.numbers);
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

    public void removeLast() {
        if (!isEmpty()) {
            this.numbers.remove(this.numbers.size() - 1);
        }
    }

    public int size() {
        return this.numbers.size();
    }

    public Long get(int index) {
        return this.numbers.get(index);
    }

    @Override
    public String toString() {
        return "ListOfLong{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfLong that = (ListOfLong) o;

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

    public void removeAt(int index) {
        this.numbers.remove(index);
    }

    public boolean contains(long suspect) {
        boolean isContained = this.numbers.contains(suspect);
        return isContained;
    }

    public Long first() {
        return get(0);
    }

    public Long last() {
        return get(size()-1);
    }
}
