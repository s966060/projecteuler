package org.fde.util;

import org.apache.commons.lang3.Validate;

import java.util.*;
import java.util.function.Consumer;

public class ListOfLong implements Iterable<Long> {
    private final List<Long> numbers;
    private String last;

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

    private ListOfLong(List<Long> numbers) {
        this.numbers = numbers;
    }

    public ListOfLong(Collection<Long> other) {
        for (Long number : other) {
            Validate.notNull(number);
        }

        this.numbers = new ArrayList<>(other);
    }

    public static ListOfLong createListOfLong(long... numbers) {
        ListOfLong result = new ListOfLong();

        for (long n : numbers) {
            result.add(Long.valueOf(n));
        }

        return result;
    }

    public static ListOfLong createListOfLong(int... numbers) {
        ListOfLong result = new ListOfLong();

        for (int n : numbers) {
            result.add(Long.valueOf(n));
        }

        return result;
    }

    public ListOfLong getUnModifiableListOfLong() {
        return new ListOfLong(Collections.unmodifiableList(this.numbers));
    }

    public void add(Long number) {
        Validate.notNull(number);
        this.numbers.add(number);
    }

    public void add(Integer number) {
        Validate.notNull(number);
        this.numbers.add(number.longValue());
    }

    public void add(int index, Long number) {
        Validate.notNull(number);
        this.numbers.add(index, number);
    }

    public void addAll(ListOfLong other) {
        this.numbers.addAll(other.numbers);
    }

    public void addAll(Long... other) {
        for (Long number : other) {
            Validate.notNull(number);
        }

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
            removeAt(getLastIndex());
        }
    }


    public void removeFirst() {
        if (!isEmpty()) {
            removeAt(0);
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

    public boolean containsByBinarySearch(long suspect) {
        int index = Collections.binarySearch(this.numbers, suspect);
        return index >= 0;
    }

    public Long first() {
        return get(0);
    }

    public Long last() {
        return get(getLastIndex());
    }

    public ListOfLong getIntersection(ListOfLong other) {
        ListOfLong newThis = new ListOfLong(this);
        ListOfLong newOther = new ListOfLong(other);

        ListOfLong intersection = new ListOfLong();

        for (Iterator<Long> thisIterator = newThis.iterator(); thisIterator.hasNext(); ) {
            Long value = thisIterator.next();

            for (Iterator<Long> otherIterator = newOther.iterator(); otherIterator.hasNext(); ) {
                if (value.equals(otherIterator.next())) {
                    thisIterator.remove();
                    otherIterator.remove();
                    intersection.add(value);
                    break;
                }
            }
        }

        return intersection;
    }

    public void remove(ListOfLong other) {
        for (Long value : other) {
            for (Iterator<Long> it = iterator(); it.hasNext(); ) {
                if (value.equals(it.next())) {
                    it.remove();
                    break;
                }
            }
        }
    }

    public void reverse() {
        Collections.reverse(this.numbers);
    }

    public void rotateRight() {
        if (!isEmpty()) {
            Long last = last();
            removeAt(getLastIndex());
            add(0, last);
        }
    }

    public ListOfLong subList(int fromIndex, int toIndex) {
        List<Long> subList = this.numbers.subList(fromIndex, toIndex);
        return new ListOfLong(subList);
    }

    public void swap(int fromIndex, int toIndex) {
        Long aValue = this.numbers.get(fromIndex);
        Long otherValue = this.numbers.get(toIndex);

        this.numbers.set(fromIndex, otherValue);
        this.numbers.set(toIndex, aValue);
    }

    public List<Long> getInternalList() {
        return Collections.unmodifiableList(this.numbers);
    }

    public static ListOfLong ofSize(int size) {
        return new ListOfLong(new ArrayList<>(size));
    }

    private int getLastIndex() {
        return size() - 1;
    }
}
