package org.fde.util.permutations;

import org.fde.util.ListOfLong;

public class OrderedPermutation {
    private final ListOfLong list;

    public OrderedPermutation() {
        this.list = new ListOfLong();
    }

    public OrderedPermutation(long... elements) {
        this();

        for (long el : elements) {
            add(el);
        }
    }

    private OrderedPermutation(ListOfLong list) {
        this.list = list;
    }

    public void add(long el) {
        this.list.add(el);
    }

    @Override
    public String toString() {
        return "OrderedPermutation{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedPermutation that = (OrderedPermutation) o;

        return list.equals(that.list);

    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}
