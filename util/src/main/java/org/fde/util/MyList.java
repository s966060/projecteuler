package org.fde.util;

import java.util.*;
import java.util.function.Consumer;

class MyList<T extends  Comparable<T>> implements Iterable<T> {
    private final List<T> list;

    MyList() {
        this.list = new ArrayList<T>();
    }

    MyList(Collection<T> other) {
        this.list = new ArrayList<T>(other);
    }

    MyList(MyList<T> other) {
        this(other.list);
    }

    void add(T value) {
        list.add(value);
    }

    void add(int index, T value) {
        list.add(index, value);
    }

    void sort() {
        Collections.sort(this.list);
    }

    boolean isEmpty() {
        return this.list.isEmpty();
    }

    void removeLast() {
        if (!isEmpty()) {
            removeAt(size() - 1);
        }
    }

    void removeFirst() {
        if (!isEmpty()) {
            removeAt(0);
        }
    }

    int size() {
        return this.list.size();
    }

    T get(int index) {
        return this.list.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.list.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return this.list.spliterator();
    }

    void removeAt(int index) {
        this.list.remove(index);
    }

    T first() {
        return get(0);
    }

    T last() {
        return get(size() - 1);
    }

    MyList<T> getIntersection(MyList<T> other) {
        MyList<T> newThis = new MyList<T>(this);
        MyList<T> newOther = new MyList<T>(other);

        MyList<T> intersection = new MyList<T>();

        for (Iterator<T> thisIterator = newThis.iterator(); thisIterator.hasNext(); ) {
            T value = thisIterator.next();

            for (Iterator<T> otherIterator = newOther.iterator(); otherIterator.hasNext(); ) {
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

    void remove(List<T> other) {
        for (T value : other) {
            for (Iterator<T> it = iterator(); it.hasNext(); ) {
                if (value.equals(it.next())) {
                    it.remove();
                    break;
                }
            }
        }
    }

    void reverse() {
        Collections.reverse(this.list);
    }

    void rotateRight() {
        if (!isEmpty()) {
            T last = last();
            removeAt(size() - 1);
            add(0, last);
        }
    }

    MyList<T> subList(int fromIndex, int toIndex) {
        return new MyList<T>(this.list.subList(fromIndex, toIndex));
    }

    void swap(int fromIndex, int toIndex) {
        T aValue = this.list.get(fromIndex);
        T otherValue = this.list.get(toIndex);

        this.list.set(fromIndex, otherValue);
        this.list.set(toIndex, aValue);
    }

    List<T> getInternalList() {
        return Collections.unmodifiableList(this.list);
    }

    void addAll(MyList<T> other) {
        this.list.addAll(other.list);
    }
}
