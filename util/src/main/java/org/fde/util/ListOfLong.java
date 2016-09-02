package org.fde.util;

import java.util.*;
import java.util.function.Consumer;

public class ListOfLong implements Iterable<Long> {
    private final List<Long> numbers;

    public ListOfLong() {
        this.numbers = new ArrayList<>();
    }

    public ListOfLong(Long... numbers) {
        this.numbers = new ArrayList<>(Arrays.asList(numbers));
    }

    public static ListOfLong createListOfLong(Long... numbers) {
        return new ListOfLong(numbers);
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
}
