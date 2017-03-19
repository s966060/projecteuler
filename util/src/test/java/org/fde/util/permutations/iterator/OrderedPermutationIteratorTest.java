package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationList;
import org.fde.util.permutations.factory.OrderedPermutationFactory;
import org.junit.Test;

import java.util.Iterator;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.fde.util.permutations.Permutation.createPermutation;
import static org.fde.util.permutations.iterator.OrderedPermutationIterator.createOrderedPermutationIterator;
import static org.junit.Assert.assertEquals;

public class OrderedPermutationIteratorTest {
    @Test
    public void empty_thePermutationsOf() {
        Iterator<Permutation> actual = createActual();

        PermutationList expected = new PermutationList()
                .add(createPermutation());

        check(expected, actual);
    }

    @Test
    public void one_thePermutationsOf() {
        Iterator<Permutation> actual = createActual(1);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1));

        check(expected, actual);
    }

    @Test
    public void two_thePermutationsOf() {
        Iterator<Permutation> actual = createActual(1, 2);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2))
                .add(createPermutation(2, 1));

        check(expected, actual);
    }

    @Test
    public void three_thePermutationsOf() {
        Iterator<Permutation> actual = createActual(1, 2, 3);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2, 3))
                .add(createPermutation(1, 3, 2))
                .add(createPermutation(2, 1, 3))
                .add(createPermutation(2, 3, 1))
                .add(createPermutation(3, 1, 2))
                .add(createPermutation(3, 2, 1));

        check(expected, actual);
    }

    @Test
    public void four_thePermutationsOf() {
        Iterator<Permutation> actual = createActual(1, 2, 3, 4);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2, 3, 4))
                .add(createPermutation(1, 2, 4, 3))
                .add(createPermutation(1, 3, 2, 4))
                .add(createPermutation(1, 3, 4, 2))
                .add(createPermutation(1, 4, 2, 3))
                .add(createPermutation(1, 4, 3, 2))

                .add(createPermutation(2, 1, 3, 4))
                .add(createPermutation(2, 1, 4, 3))
                .add(createPermutation(2, 3, 1, 4))
                .add(createPermutation(2, 3, 4, 1))
                .add(createPermutation(2, 4, 1, 3))
                .add(createPermutation(2, 4, 3, 1))

                .add(createPermutation(3, 1, 2, 4))
                .add(createPermutation(3, 1, 4, 2))
                .add(createPermutation(3, 2, 1, 4))
                .add(createPermutation(3, 2, 4, 1))
                .add(createPermutation(3, 4, 1, 2))
                .add(createPermutation(3, 4, 2, 1))

                .add(createPermutation(4, 1, 2, 3))
                .add(createPermutation(4, 1, 3, 2))
                .add(createPermutation(4, 2, 1, 3))
                .add(createPermutation(4, 2, 3, 1))
                .add(createPermutation(4, 3, 1, 2))
                .add(createPermutation(4, 3, 2, 1));

        check(expected, actual);
    }

    @Test
    public void testVersusTheOrderedPermutationFactory() {
        ListOfLong input = createListOfLong(1, 2, 3, 4, 5, 6, 7, 8, 9);

        OrderedPermutationFactory factory = new OrderedPermutationFactory(input);
        PermutationList expected = factory.getPermutations();

        OrderedPermutationIterator actual = createOrderedPermutationIterator(input);

        check(expected, actual);
    }

    private Iterator<Permutation> createActual(long... values) {
        ListOfLong input = new ListOfLong();

        for (long value : values) {
            input.add(value);
        }

        return createOrderedPermutationIterator(input);
    }

    private void check(PermutationList expected,
                       Iterator<Permutation> actualIterator) {

        PermutationList actual = new PermutationList();

        while (actualIterator.hasNext()) {
            Permutation value = actualIterator.next();
            actual.add(value);
        }

        check(expected, actual);
    }

    private void check(PermutationList expected,
                       PermutationList actual) {

        assertEquals(expected, actual);
    }
}
