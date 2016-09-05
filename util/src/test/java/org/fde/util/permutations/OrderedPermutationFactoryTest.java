package org.fde.util.permutations;

import org.fde.util.ListOfLong;
import org.junit.Test;

import static org.fde.util.ListOfLong.createListOfLong;
import static org.junit.Assert.assertEquals;

public class OrderedPermutationFactoryTest {
    @Test
    public void one_thePermutationsOf() {
        ListOfLong input = createListOfLong(1L);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(new Permutation(1L));

        assertEquals(expected, actual);
    }

    @Test
    public void two_thePermutationsOf() {
        ListOfLong input = createListOfLong(1L, 2L);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(new Permutation(1L, 2L))
                .add(new Permutation(2L, 1L));

        assertEquals(expected, actual);
    }

    @Test
    public void three_thePermutationsOf() {
        ListOfLong input = createListOfLong(1L, 2L, 3L);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(new Permutation(1L, 2L, 3L))
                .add(new Permutation(1L, 3L, 2L))
                .add(new Permutation(2L, 1L, 3L))
                .add(new Permutation(2L, 3L, 1L))
                .add(new Permutation(3L, 1L, 2L))
                .add(new Permutation(3L, 2L, 1L));

        assertEquals(expected, actual);
    }

    @Test
    public void four_thePermutationsOf() {
        ListOfLong input = createListOfLong(1L, 2L, 3L, 4L);

        PermutationList actual = getPermutations(input);

        PermutationList expected = new PermutationList()
                .add(new Permutation(1L, 2L, 3L, 4L))
                .add(new Permutation(1L, 2L, 4L, 3L))
                .add(new Permutation(1L, 3L, 2L, 4L))
                .add(new Permutation(1L, 3L, 4L, 2L))
                .add(new Permutation(1L, 4L, 2L, 3L))
                .add(new Permutation(1L, 4L, 3L, 2L))

                .add(new Permutation(2L, 1L, 3L, 4L))
                .add(new Permutation(2L, 1L, 4L, 3L))
                .add(new Permutation(2L, 3L, 1L, 4L))
                .add(new Permutation(2L, 3L, 4L, 1L))
                .add(new Permutation(2L, 4L, 1L, 3L))
                .add(new Permutation(2L, 4L, 3L, 1L))

                .add(new Permutation(3L, 1L, 2L, 4L))
                .add(new Permutation(3L, 1L, 4L, 2L))
                .add(new Permutation(3L, 2L, 1L, 4L))
                .add(new Permutation(3L, 2L, 4L, 1L))
                .add(new Permutation(3L, 4L, 1L, 2L))
                .add(new Permutation(3L, 4L, 2L, 1L))

                .add(new Permutation(4L, 1L, 2L, 3L))
                .add(new Permutation(4L, 1L, 3L, 2L))
                .add(new Permutation(4L, 2L, 1L, 3L))
                .add(new Permutation(4L, 2L, 3L, 1L))
                .add(new Permutation(4L, 3L, 1L, 2L))
                .add(new Permutation(4L, 3L, 2L, 1L));

        assertEquals(expected, actual);
    }

    private PermutationList getPermutations(ListOfLong input) {
        return new OrderedPermutationFactory(input).getPermutations();
    }
}
