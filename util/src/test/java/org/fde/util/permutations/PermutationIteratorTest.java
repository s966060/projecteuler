package org.fde.util.permutations;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.fde.util.permutations.Permutation.createPermutation;
import static org.junit.Assert.assertEquals;

public class PermutationIteratorTest {
    @Test
    public void one_thePermutationsOf() {
        PermutationList actual = createActual(1);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1));

        assertEquals(expected, actual);
    }

    @Test
    public void two_thePermutationsOf() {
        PermutationList actual = createActual(1, 2);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2))
                .add(createPermutation(2, 1));

        assertEquals(expected, actual);
    }

    @Test
    public void three_thePermutationsOf() {
        PermutationList actual = createActual(1, 2, 3);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2, 3))
                .add(createPermutation(2, 1, 3))
                .add(createPermutation(2, 3, 1))
                .add(createPermutation(3, 2, 1))
                .add(createPermutation(3, 1, 2))
                .add(createPermutation(1, 3, 2));

        assertEquals(expected, actual);
    }

    @Test
    public void four_thePermutationsOf() {
        PermutationList actual = createActual(1, 2, 3, 4);

        PermutationList expected = new PermutationList()
                .add(createPermutation(1, 2, 3, 4))
                .add(createPermutation(1, 2, 4, 3))
                .add(createPermutation(1, 4, 2, 3))
                .add(createPermutation(4, 1, 2, 3))

                .add(createPermutation(1, 3, 2, 4))
                .add(createPermutation(1, 3, 4, 2))
                .add(createPermutation(1, 4, 3, 2))
                .add(createPermutation(4, 1, 3, 2))

                .add(createPermutation(3, 1, 2, 4))
                .add(createPermutation(3, 1, 4, 2))
                .add(createPermutation(3, 4, 1, 2))
                .add(createPermutation(4, 3, 1, 2))

                .add(createPermutation(2, 1, 3, 4))
                .add(createPermutation(2, 1, 4, 3))
                .add(createPermutation(2, 4, 1, 3))
                .add(createPermutation(4, 2, 1, 3))

                .add(createPermutation(2, 3, 1, 4))
                .add(createPermutation(2, 3, 4, 1))
                .add(createPermutation(2, 4, 3, 1))
                .add(createPermutation(4, 2, 3, 1))

                .add(createPermutation(3, 2, 1, 4))
                .add(createPermutation(3, 2, 4, 1))
                .add(createPermutation(3, 4, 2, 1))
                .add(createPermutation(4, 3, 2, 1));

        assertEquals(expected, actual);
    }

    private PermutationList getPermutations(ListOfLong input) {
        PermutationList list = new PermutationList();

        PermutationIterator it = new PermutationIterator(input);

        while(it.hasNext()) {
            list.add(it.next());
        }

        return list;
    }

    private PermutationList createActual(long... values) {
        ListOfLong input = new ListOfLong();

        for (long value : values) {
            input.add(value);
        }

        return getPermutations(input);
    }
}
