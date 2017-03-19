package org.fde.util.permutations.iterator;

import org.fde.util.ListOfLong;
import org.fde.util.permutations.Permutation;
import org.fde.util.permutations.PermutationList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.fde.util.permutations.Permutation.createPermutation;
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

    private Iterator<Permutation> createActual(long... values) {
        ListOfLong input = new ListOfLong();

        for (long value : values) {
            input.add(value);
        }

        return new OrderedPermutationIterator(input);
    }

    private void check(PermutationList expected,
                       Iterator<Permutation> actualIterator) {

        Iterator<Permutation> expectedIterator = expected.iterator();

        check(expectedIterator, actualIterator);
    }

    private void check(Iterator<Permutation> expectedIterator,
                       Iterator<Permutation> actualIterator) {

        while (expectedIterator.hasNext()) {
            Permutation e = expectedIterator.next();

            if (actualIterator.hasNext()) {
                Permutation a = actualIterator.next();

                assertEquals(e, a);
            } else {
                String msg = String.format(
                        "expected (%s) while actual iterator is exhausted", e);

                Assert.fail(msg);
            }
        }

        if (expectedIterator.hasNext()) {
            Assert.fail();
        }
    }
}
